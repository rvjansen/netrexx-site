/* Generated from 'NightlyBuildData.nrx' 16 Feb 2014 16:06:33 [v3.03] *//* Options: Comments Compact Decimal Java Logo Replace Sourcedir Trace2 UTF8 Verbose3 */package com.rvjansen;

/**
 * Class NightlyBuildData implements... 
 * <BR>
 * Created on: za, 09, mrt 2013 00:12:50 +0100
 */
public class NightlyBuildData{private static final java.lang.String $0="NightlyBuildData.nrx";

/* properties indirect */
private java.lang.String out;
/**
 * Default constructor
 */
public NightlyBuildData(){super();java.io.File f;java.text.SimpleDateFormat df;netrexx.lang.Rexx longdate;
f=new java.io.File("webapps/ROOT/netrexx/netrexxc/trunk/build/lib/NetRexxC.jar");
df=new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ssSS");
longdate=netrexx.lang.Rexx.toRexx(df.format(new java.util.Date(f.lastModified())));
this.setOut(netrexx.lang.Rexx.toString(longdate));return;}public java.lang.String getOut(){return out;}public void setOut(java.lang.String $1){out=$1;return;}}
