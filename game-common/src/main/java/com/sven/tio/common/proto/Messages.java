// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: messages.proto

package com.sven.tio.common.proto;

public final class Messages {
  private Messages() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Frame_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Frame_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LoginMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LoginMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_RegisterRoutMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_RegisterRoutMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_HeartBeatMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_HeartBeatMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ServerBusyMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ServerBusyMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CommonProtocol_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CommonProtocol_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CommonProtocol_CommonHeader_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CommonProtocol_CommonHeader_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_CommonProtocol_LiveCommonHeader_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_CommonProtocol_LiveCommonHeader_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016messages.proto\"-\n\005Frame\022\023\n\013messageType" +
      "\030\002 \001(\t\022\017\n\007payload\030\017 \001(\014\".\n\014LoginMessage\022" +
      "\014\n\004name\030\001 \001(\t\022\020\n\010password\030\002 \001(\t\"\'\n\023Regis" +
      "terRoutMessage\022\020\n\010serverId\030\001 \001(\005\"#\n\020Hear" +
      "tBeatMessage\022\017\n\007message\030\001 \001(\t\"$\n\021ServerB" +
      "usyMessage\022\017\n\007message\030\001 \001(\t\"\341\002\n\016CommonPr" +
      "otocol\0220\n\nCommHeader\030\001 \001(\0132\034.CommonProto" +
      "col.CommonHeader\0224\n\nLiveHeader\030\002 \001(\0132 .C" +
      "ommonProtocol.LiveCommonHeader\022\014\n\004Data\030\003" +
      " \001(\014\032R\n\014CommonHeader\022\021\n\tCommandId\030\001 \001(\r\022" +
      "\r\n\005SeqId\030\002 \001(\r\022\017\n\007Version\030\003 \001(\r\022\017\n\007FromU" +
      "id\030\004 \001(\t\032\204\001\n\020LiveCommonHeader\022\020\n\010LiveTyp" +
      "e\030\001 \001(\r\022\016\n\006LiveId\030\002 \001(\r\022\022\n\nDemandType\030\003 " +
      "\001(\r\022\020\n\010DemandId\030\004 \001(\r\022\022\n\nToDemandId\030\005 \001(" +
      "\r\022\024\n\014ToDemandType\030\006 \001(\rB\035\n\031com.sven.tio." +
      "common.protoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_Frame_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Frame_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Frame_descriptor,
        new java.lang.String[] { "MessageType", "Payload", });
    internal_static_LoginMessage_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_LoginMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LoginMessage_descriptor,
        new java.lang.String[] { "Name", "Password", });
    internal_static_RegisterRoutMessage_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_RegisterRoutMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_RegisterRoutMessage_descriptor,
        new java.lang.String[] { "ServerId", });
    internal_static_HeartBeatMessage_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_HeartBeatMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_HeartBeatMessage_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_ServerBusyMessage_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_ServerBusyMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ServerBusyMessage_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_CommonProtocol_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_CommonProtocol_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CommonProtocol_descriptor,
        new java.lang.String[] { "CommHeader", "LiveHeader", "Data", });
    internal_static_CommonProtocol_CommonHeader_descriptor =
      internal_static_CommonProtocol_descriptor.getNestedTypes().get(0);
    internal_static_CommonProtocol_CommonHeader_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CommonProtocol_CommonHeader_descriptor,
        new java.lang.String[] { "CommandId", "SeqId", "Version", "FromUid", });
    internal_static_CommonProtocol_LiveCommonHeader_descriptor =
      internal_static_CommonProtocol_descriptor.getNestedTypes().get(1);
    internal_static_CommonProtocol_LiveCommonHeader_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_CommonProtocol_LiveCommonHeader_descriptor,
        new java.lang.String[] { "LiveType", "LiveId", "DemandType", "DemandId", "ToDemandId", "ToDemandType", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
