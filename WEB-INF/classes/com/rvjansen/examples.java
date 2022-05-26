/* Generated from 'examples.nrx' 26 May 2022 23:42:57 [v4.04] *//* Options: Annotations Comments Compact Decimal Java Logo Replace Sourcedir Trace2 UTF8 Verbose3 */package com.rvjansen;

/**
 * Class examples implements... 
 * <BR>
 * Created on: do, 28, feb 2013 22:09:06 +0100
 */
public class examples{private static final char[] $01={2,1,124,10,1,0,1,10,1,1,0};private static final netrexx.lang.Rexx $02=new netrexx.lang.Rexx(1);private static final netrexx.lang.Rexx $03=new netrexx.lang.Rexx(0);private static final netrexx.lang.Rexx $04=new netrexx.lang.Rexx(2);private static final netrexx.lang.Rexx $05=netrexx.lang.Rexx.toRexx("<a href=");private static final netrexx.lang.Rexx $06=new netrexx.lang.Rexx('/');private static final netrexx.lang.Rexx $07=new netrexx.lang.Rexx('>');private static final netrexx.lang.Rexx $08=netrexx.lang.Rexx.toRexx("<a>");private static final netrexx.lang.Rexx $09=netrexx.lang.Rexx.toRexx("</td><td>");private static final netrexx.lang.Rexx $010=netrexx.lang.Rexx.toRexx("</td></tr>");private static final java.lang.String $0="examples.nrx";
/* properties indirect */
private javax.servlet.jsp.JspWriter output;
private java.util.TreeMap legendaMap=new java.util.TreeMap();
private javax.servlet.http.HttpServletRequest request;
/**
 * Default constructor
 */
@SuppressWarnings("unchecked")
public synchronized java.lang.String doit(){java.lang.String context;
context=this.request.getContextPath();
{try{
output.println("<h3>RosettaCode Examples for NetRexx</h3>");
perDirectory(netrexx.lang.Rexx.toRexx("/home/netrexx/website/netrexx/netrexxc/examples/rosettacode"));

output.println("<h3>QuickTour Examples for NetRexx (from the QuickStart Guide)</h3>");
perDirectory(netrexx.lang.Rexx.toRexx("/home/netrexx/website/netrexx/netrexxc/examples/quicktour"));

output.println("<h3>Original IBM Examples for NetRexx</h3>");
perDirectory(netrexx.lang.Rexx.toRexx("/home/netrexx/website/netrexx/netrexxc/examples/ibm-historic"));

output.println("<h3>Windows example for NetRexx</h3>");
perDirectory(netrexx.lang.Rexx.toRexx("/home/netrexx/website/netrexx/netrexxc/examples/windows"));

output.println("<h3>Examples for NetRexx 3.01</h3>");
perDirectory(netrexx.lang.Rexx.toRexx("/home/netrexx/website/netrexx/netrexxc/examples/new-3.01"));

output.println("<h3>MQTT examples for NetRexx</h3>");
perDirectory(netrexx.lang.Rexx.toRexx("/home/netrexx/website/netrexx/netrexxc/examples/enterprise/mqtt"));

output.println("<h3>WebSphere MQ examples for NetRexx</h3>");
perDirectory(netrexx.lang.Rexx.toRexx("/home/netrexx/website/netrexx/netrexxc/examples/enterprise/wmq"));}

catch (java.io.IOException $1){
netrexx.lang.RexxIO.Say("some io error happened in examples.nrx");
}}
return "";}

@SuppressWarnings("unchecked")
public synchronized void perDirectory(netrexx.lang.Rexx dirName_) throws java.io.IOException,java.io.FileNotFoundException{netrexx.lang.Rexx context;java.io.File f;java.io.BufferedReader in=null;netrexx.lang.Rexx line=null;netrexx.lang.Rexx filename=null;netrexx.lang.Rexx explanation=null;netrexx.lang.Rexx linkDir;java.io.File files[];netrexx.lang.Rexx i=null;netrexx.lang.Rexx endDelim=null;netrexx.lang.Rexx fileName2=null;netrexx.lang.Rexx link=null;java.lang.Object expl=null;

context=new netrexx.lang.Rexx(this.request.getContextPath());
output.println("  <table><tr class = \"rowH\"><th>Example</th><th>Description</th></tr>");
// get directory
f=new java.io.File(netrexx.lang.Rexx.toString(dirName_));
{try{
in=new java.io.BufferedReader((java.io.Reader)(new java.io.FileReader(netrexx.lang.Rexx.toString(dirName_.OpCc(null,netrexx.lang.Rexx.toRexx("/legenda.txt"))))));
{$2:for(;;){
line=netrexx.lang.Rexx.toRexx(in.readLine());
if (line==null) break $2;
{netrexx.lang.Rexx $3[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(line,$01,$3);filename=$3[0];explanation=$3[1];}
legendaMap.put((java.lang.Object)filename,(java.lang.Object)explanation);
}}}
catch (java.lang.Exception $4){
}} // do

linkDir=dirName_.substr(new netrexx.lang.Rexx((byte)24));



files=f.listFiles();
{netrexx.lang.Rexx $5=new netrexx.lang.Rexx(files.length).OpSub(null,$02);i=new netrexx.lang.Rexx((byte)0);i:for(;i.OpLtEq(null,$5);i=i.OpAdd(null,new netrexx.lang.Rexx(1))){
filename=new netrexx.lang.Rexx(files[i.toint()].toString());
if ((filename.pos(netrexx.lang.Rexx.toRexx(".svn"))).OpGt(null,$03)) continue i;
if ((filename.pos(netrexx.lang.Rexx.toRexx("makefile"))).OpGt(null,$03)) continue i;
if ((filename.pos(netrexx.lang.Rexx.toRexx("legenda.txt"))).OpGt(null,$03)) continue i;
endDelim=filename.lastpos(new netrexx.lang.Rexx('/'));
fileName2=filename.substr(endDelim.OpAdd(null,$02));

if (i.OpRem(null,$04).OpEq(null,$03)) output.println("<tr class=\"rowA\"><td>");
else output.println("<tr class=\"rowB\"><td>");
link=((((($05.OpCc(null,linkDir)).OpCc(null,$06)).OpCc(null,netrexx.lang.Rexx.toRexx(fileName2.toString()))).OpCc(null,$07)).OpCc(null,netrexx.lang.Rexx.toRexx(fileName2.toString()))).OpCc(null,$08);
output.println(link.toString());
expl=this.legendaMap.get((java.lang.Object)fileName2);
if (expl==null) expl=(java.lang.Object)"";
expl=(java.lang.Object)(($09.OpCc(null,new netrexx.lang.Rexx(java.lang.String.valueOf(expl)))).OpCc(null,$010));
output.println(expl);
}}/*i*/
output.println("</table>");return;}public javax.servlet.jsp.JspWriter getOutput(){return output;}public void setOutput(javax.servlet.jsp.JspWriter $6){output=$6;return;}public java.util.TreeMap getLegendaMap(){return legendaMap;}public void setLegendaMap(java.util.TreeMap $7){legendaMap=$7;return;}public javax.servlet.http.HttpServletRequest getRequest(){return request;}public void setRequest(javax.servlet.http.HttpServletRequest $8){request=$8;return;}public examples(){return;}}

