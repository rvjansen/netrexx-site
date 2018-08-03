/* Generated from 'message.nrx' 24 Apr 2013 15:14:29 [v3.02] *//* Options: Binary Comments Compact Decimal Java Logo Replace Sourcedir Trace2 UTF8 Verbose3 */package com.rvjansen;


/**
 * Class message implements the message to send from the webpage 
 * <BR>
 * Created on: di, 12, mrt 2013 12:13:28 +0100
 */
public class message{private static final java.lang.String $0="message.nrx";
/* properties indirect */
private java.lang.String firstname;
private java.lang.String lastname;
private java.lang.String emailaddr;
private java.lang.String message_;
private javax.servlet.jsp.PageContext pc;

/**
 * Default constructor
 */
public message(){super();return;}

public synchronized netrexx.lang.Rexx doit() throws java.io.IOException{java.io.PrintWriter out;
out=new java.io.PrintWriter((java.io.Writer)(new java.io.BufferedWriter((java.io.Writer)(new java.io.FileWriter("messages.txt",true)))));
out.println((java.lang.Object)(new java.util.Date()));
out.println(pc.getRequest().getRemoteAddr());
out.println(this.getFirstname());
out.println(this.getLastname());
out.println(this.getEmailaddr());
out.println(this.getMessage_());
out.println("-----------------------");
out.close();
return netrexx.lang.Rexx.toRexx("");}public java.lang.String getFirstname(){return firstname;}public void setFirstname(java.lang.String $1){firstname=$1;return;}public java.lang.String getLastname(){return lastname;}public void setLastname(java.lang.String $2){lastname=$2;return;}public java.lang.String getEmailaddr(){return emailaddr;}public void setEmailaddr(java.lang.String $3){emailaddr=$3;return;}public java.lang.String getMessage_(){return message_;}public void setMessage_(java.lang.String $4){message_=$4;return;}public javax.servlet.jsp.PageContext getPc(){return pc;}public void setPc(javax.servlet.jsp.PageContext $5){pc=$5;return;}}

