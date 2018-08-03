/* Generated from 'tests.nrx' 16 Feb 2014 16:06:33 [v3.03] *//* Options: Comments Compact Decimal Java Logo Replace Sourcedir Trace2 UTF8 Verbose3 */package com.rvjansen;

/**
 * Class tests implements... 
 * <BR>
 * Created on: vr, 15, mrt 2013 17:42:38 +0100
 */
public class tests{private static final netrexx.lang.Rexx $01=netrexx.lang.Rexx.toRexx("Tests");private static final java.lang.String $0="tests.nrx";
/* properties indirect */
private java.lang.String out=new java.lang.String();

/**
 * Default constructor
 */
public tests() throws java.io.IOException{super();netrexx.lang.Rexx line;java.io.BufferedReader in=null;
line=netrexx.lang.Rexx.toRexx("");
{try{
in=new java.io.BufferedReader((java.io.Reader)(new java.io.FileReader("webapps/ROOT/netrexx/netrexxc/test/testlog.txt")));
{$1:for(;;){
line=netrexx.lang.Rexx.toRexx(in.readLine());
if (line==null) break $1;
if ((line.left(new netrexx.lang.Rexx((byte)5))).OpEq(null,$01)) this.setOut(line.toString());
}}}
catch (java.io.FileNotFoundException $2){
this.setOut("test results not found");
}}return;}public java.lang.String getOut(){return out;}public void setOut(java.lang.String $3){out=$3;return;}}

