package com.google.ar.sceneform.samples.hellosceneform.utilities;

/*
This class keeps the tool strings & data.
 */

public class Utilities {

    //  Tool table field constants
    public static final String TOOL_TABLE="tool";
    public static final String FIELD_ID="id";
    public static final String FIELD_PRICE="price";
    public static final String FIELD_NAME="name";
    public static final String FIELD_DESCRIPTION="description";
    public static String TOOL_ID="";
    public static String TOOL_PRICE="";
    public static String TOOL_NAME="";
    public static String TOOL_DESCRIPTION="";
    public static int TOOL_MODEL = 0;       //  To switch between the two 3d models.

    public static final String CREATE_TOOL_TABLE="CREATE TABLE "+TOOL_TABLE+
            " ("+FIELD_ID+" INTEGER, "+FIELD_PRICE+" FLOAT, "+FIELD_NAME+
            " TEXT, "+FIELD_DESCRIPTION+" TEXT)";

}
