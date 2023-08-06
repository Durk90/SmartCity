package com.smartcity.maincontroller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.smartcity.energystorage.*;
import com.smartcity.energyconsumption.*;
import com.smartcity.solarpanels.*;
import com.smartcity.windturbines.*;
import io.grpc.ManagedChannelBuilder;

public class MainControllerGUI {

    private JFrame frame;
    private EnergyStorageGrpc.EnergyStorageBlockingStub energyStorageStub;
    private EnergyConsumptionGrpc.EnergyConsumptionBlockingStub energyConsumptionStub;
    private SolarPanelsGrpc.SolarPanelsBlockingStub solarPanelsStub;
    private WindTurbinesGrpc.WindTurbinesBlockingStub windTurbinesStub;
    private JLabel energyStoredLabel; // New label for displaying energy storage

    public MainControllerGUI() {
        frame = new JFrame("Smart City Main Controller");
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize gRPC stubs
        energyStorageStub = EnergyStorageGrpc.newBlockingStub(ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build());
        energyConsumptionStub = EnergyConsumptionGrpc.newBlockingStub(ManagedChannelBuilder.forAddress("localhost", 50052).usePlaintext().build());
        solarPanelsStub = SolarPanelsGrpc.newBlockingStub(ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build());
        windTurbinesStub = WindTurbinesGrpc.newBlockingStub(ManagedChannelBuilder.forAddress("localhost", 50054).usePlaintext().build());

        // Create buttons and labels for interaction
        JButton storeEnergyButton = new JButton("Store Energy");
        JButton consumeEnergyButton = new JButton("Consume Energy");
        JButton generateEnergyButton = new JButton("Generate Energy");
        JLabel resultLabel = new JLabel("Result: ");
        energyStoredLabel = new JLabel("Energy Stored: 0.0");        

        // Button action listeners
        storeEnergyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double energyAmount = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter energy amount to store:"));
                StoreEnergyRequest request = StoreEnergyRequest.newBuilder().setEnergyAmount(energyAmount).build();
                StoreEnergyResponse response = energyStorageStub.storeEnergy(request);

                if (response.getSuccess()) {
                    double currentEnergyStored = Double.parseDouble(energyStoredLabel.getText().substring("Energy Stored: ".length()));
                    currentEnergyStored += energyAmount;
                    energyStoredLabel.setText("Energy Stored: " + currentEnergyStored);
                    resultLabel.setText("Result: Energy stored successfully!");
                } else {
                    resultLabel.setText("Result: Failed to store energy.");
                }
            }
        });

        consumeEnergyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double energyAmount = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter energy amount to consume:"));
                ConsumeEnergyRequest request = ConsumeEnergyRequest.newBuilder().setEnergyAmount(energyAmount).build();
                ConsumeEnergyResponse response = energyConsumptionStub.consumeEnergy(request);

                if (response.getSuccess()) {
                    resultLabel.setText("Result: Energy consumed successfully!");
                } else {
                    resultLabel.setText("Result: Insufficient energy for consumption!");
                }
            }
        });

        generateEnergyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = { "Solar Panels", "Wind Turbines" };
                int selectedOption = JOptionPane.showOptionDialog(frame, "Select energy generation method:", "Generate Energy",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                if (selectedOption == 0) { // Solar Panels
                    double sunExposure = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter sun exposure:"));
                    com.smartcity.solarpanels.GenerateEnergyRequest request = com.smartcity.solarpanels.GenerateEnergyRequest.newBuilder().setSunExposure(sunExposure).build();
                    com.smartcity.solarpanels.GenerateEnergyResponse response = solarPanelsStub.generateEnergy(request);
                    double energyGenerated = response.getEnergyGenerated();

                    // Add the generated energy to storage
                    StoreEnergyRequest storeRequest = StoreEnergyRequest.newBuilder().setEnergyAmount(energyGenerated).build();
                    StoreEnergyResponse storeResponse = energyStorageStub.storeEnergy(storeRequest);

                    // Verify if energy is stored successfully
                    if (storeResponse.getSuccess()) {
                        double currentEnergyStored = Double.parseDouble(energyStoredLabel.getText().substring("Energy Stored: ".length()));
                        currentEnergyStored += energyGenerated;
                        energyStoredLabel.setText("Energy Stored: " + currentEnergyStored);
                        resultLabel.setText("Result: Energy generated (Solar Panels) and stored: " + energyGenerated);
                    } else {
                        resultLabel.setText("Result: Failed to store energy (Solar Panels).");
                    }
                } else if (selectedOption == 1) { // Wind Turbines
                    double windSpeed = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter wind speed:"));
                    com.smartcity.windturbines.GenerateEnergyRequest request = com.smartcity.windturbines.GenerateEnergyRequest.newBuilder().setWindSpeed(windSpeed).build();
                    com.smartcity.windturbines.GenerateEnergyResponse response = windTurbinesStub.generateEnergy(request);
                    double energyGenerated = response.getEnergyGenerated();

                    // Add the generated energy to storage
                    StoreEnergyRequest storeRequest = StoreEnergyRequest.newBuilder().setEnergyAmount(energyGenerated).build();
                    StoreEnergyResponse storeResponse = energyStorageStub.storeEnergy(storeRequest);

                    // Verify if energy is stored successfully
                    if (storeResponse.getSuccess()) {
                        double currentEnergyStored = Double.parseDouble(energyStoredLabel.getText().substring("Energy Stored: ".length()));
                        currentEnergyStored += energyGenerated;
                        energyStoredLabel.setText("Energy Stored: " + currentEnergyStored);
                        resultLabel.setText("Result: Energy generated (Wind Turbines) and stored: " + energyGenerated);
                    } else {
                        resultLabel.setText("Result: Failed to store energy (Wind Turbines).");
                    }
                }
            }
        });

        // Add components to the frame
        frame.add(storeEnergyButton);
        frame.add(consumeEnergyButton);
        frame.add(generateEnergyButton);
        frame.add(resultLabel);
        frame.add(energyStoredLabel); // Add the energyStoredLabel to the frame

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainControllerGUI();
            }
        });
    }
}
