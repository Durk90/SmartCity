// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: WindTurbine.proto

package com.smartcity.windturbines;

public final class WindTurbinesProto {
  private WindTurbinesProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_windturbines_GenerateEnergyRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_windturbines_GenerateEnergyRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_windturbines_GenerateEnergyResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_windturbines_GenerateEnergyResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021WindTurbine.proto\022\014windturbines\"*\n\025Gen" +
      "erateEnergyRequest\022\021\n\twindSpeed\030\001 \001(\001\"1\n" +
      "\026GenerateEnergyResponse\022\027\n\017energyGenerat" +
      "ed\030\001 \001(\0012m\n\014WindTurbines\022]\n\016generateEner" +
      "gy\022#.windturbines.GenerateEnergyRequest\032" +
      "$.windturbines.GenerateEnergyResponse\"\000B" +
      "1\n\032com.smartcity.windturbinesB\021WindTurbi" +
      "nesProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_windturbines_GenerateEnergyRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_windturbines_GenerateEnergyRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_windturbines_GenerateEnergyRequest_descriptor,
        new java.lang.String[] { "WindSpeed", });
    internal_static_windturbines_GenerateEnergyResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_windturbines_GenerateEnergyResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_windturbines_GenerateEnergyResponse_descriptor,
        new java.lang.String[] { "EnergyGenerated", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
