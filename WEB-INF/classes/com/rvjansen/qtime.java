/* Generated from 'qtime.nrx' 31 Dec 2014 16:44:46 [v3.04] *//* Options: Comments Compact Decimal Java Logo Replace Sourcedir Trace2 UTF8 Verbose3 */package com.rvjansen;

public class qtime{private static final char[] $01={1,10,5,0,0,0,1,0,0};private static final char[] $02={2,1,58,10,1,0,2,1,58,10,1,1,1,10,1,2,0};private static final netrexx.lang.Rexx $03=new netrexx.lang.Rexx(13);private static final netrexx.lang.Rexx $04=new netrexx.lang.Rexx(29);private static final netrexx.lang.Rexx $05=new netrexx.lang.Rexx(1);private static final netrexx.lang.Rexx $06=new netrexx.lang.Rexx(5);private static final netrexx.lang.Rexx $07=netrexx.lang.Rexx.toRexx("it\'s");private static final netrexx.lang.Rexx $08=new netrexx.lang.Rexx(32);private static final netrexx.lang.Rexx $09=new netrexx.lang.Rexx(2);private static final netrexx.lang.Rexx $010=new netrexx.lang.Rexx(12);private static final netrexx.lang.Rexx $011=new netrexx.lang.Rexx(0);private static final netrexx.lang.Rexx $012=new netrexx.lang.Rexx(60);private static final netrexx.lang.Rexx $013=netrexx.lang.Rexx.toRexx("five past");private static final netrexx.lang.Rexx $014=new netrexx.lang.Rexx(10);private static final netrexx.lang.Rexx $015=netrexx.lang.Rexx.toRexx("ten past");private static final netrexx.lang.Rexx $016=new netrexx.lang.Rexx(15);private static final netrexx.lang.Rexx $017=new netrexx.lang.Rexx(20);private static final netrexx.lang.Rexx $018=new netrexx.lang.Rexx(25);private static final netrexx.lang.Rexx $019=new netrexx.lang.Rexx(30);private static final netrexx.lang.Rexx $020=netrexx.lang.Rexx.toRexx("half past");private static final netrexx.lang.Rexx $021=new netrexx.lang.Rexx(35);private static final netrexx.lang.Rexx $022=new netrexx.lang.Rexx(40);private static final netrexx.lang.Rexx $023=netrexx.lang.Rexx.toRexx("twenty to");private static final netrexx.lang.Rexx $024=new netrexx.lang.Rexx(45);private static final netrexx.lang.Rexx $025=new netrexx.lang.Rexx(50);private static final netrexx.lang.Rexx $026=netrexx.lang.Rexx.toRexx("ten to");private static final netrexx.lang.Rexx $027=new netrexx.lang.Rexx(55);private static final netrexx.lang.Rexx $028=netrexx.lang.Rexx.toRexx("five to");private static final netrexx.lang.Rexx $029=netrexx.lang.Rexx.toRexx("o\'clock");private static final java.lang.String $0="qtime.nrx";

/*----------------------------------------------------------*/
/* QTIME.  This program displays the time in real English.  */
/* If "?" is given as the first argument word then the      */
/* program displays a description of itself.                */
/*----------------------------------------------------------*/

/* properties indirect */

private netrexx.lang.Rexx out=netrexx.lang.Rexx.toRexx("");

public qtime(){super();netrexx.lang.Rexx near;netrexx.lang.Rexx now=null;netrexx.lang.Rexx hour=null;netrexx.lang.Rexx min=null;netrexx.lang.Rexx sec=null;netrexx.lang.Rexx mod;netrexx.lang.Rexx numbers;

/* Nearness phrases - using associative array lookup        */
near=netrexx.lang.Rexx.toRexx("");/* default */
near.getnode(new netrexx.lang.Rexx((byte)0)).leaf=netrexx.lang.Rexx.toRexx("");/* exact */
near.getnode(new netrexx.lang.Rexx((byte)1)).leaf=netrexx.lang.Rexx.toRexx(" just gone");near.getnode(new netrexx.lang.Rexx((byte)2)).leaf=netrexx.lang.Rexx.toRexx(" just after");/* after */
near.getnode(new netrexx.lang.Rexx((byte)3)).leaf=netrexx.lang.Rexx.toRexx(" nearly");near.getnode(new netrexx.lang.Rexx((byte)4)).leaf=netrexx.lang.Rexx.toRexx(" almost");/* before */

/* Extract the hours, minutes, and seconds from the time.   */
/* Use the Java Date class as Rexx.Date not yet implemented */
{netrexx.lang.Rexx $1[]=new netrexx.lang.Rexx[2];netrexx.lang.RexxParse.parse(new netrexx.lang.Rexx(java.lang.String.valueOf(new java.util.Date())),$01,$1);now=$1[1];}/* time is fourth word */
{netrexx.lang.Rexx $2[]=new netrexx.lang.Rexx[3];netrexx.lang.RexxParse.parse(now,$02,$2);hour=$2[0];min=$2[1];sec=$2[2];}

// not needed for the current AWS host centre  
// hour = hour + 1 -- quick zulu time fix - change soon
if (hour.OpEq(null,$03)) hour=new netrexx.lang.Rexx((byte)1);

if (sec.OpGt(null,$04)) min=min.OpAdd(null,$05);/* round up minutes */
mod=min.OpRem(null,$06);/* where we are in 5 minute bracket */
out=$07.OpCc(null,near.getnode(mod).leaf);/* start building the result */
if (min.OpGt(null,$08)) hour=hour.OpAdd(null,$05);/* we are TO the hour... */
min=min.OpAdd(null,$09);/* shift minutes to straddle a 5-minute point */

// don't do this as West Virginia noon is zulu midnight
/* Now special-case the result for Noon and Midnight hours  */
// if hour//12=0 & min//60<=4 then do
//   if hour=12 then say out 'Noon.'
//              else say out 'Midnight.'
//   return                            /* we are finished here */
//   end

min=min.OpSub(null,(min.OpRem(null,$06)));/* find nearest 5 mins */
if (hour.OpGt(null,$010)) 
hour=hour.OpSub(null,$010);/* get rid of 24-hour clock */
else 
if (hour.OpEq(null,$011)) hour=new netrexx.lang.Rexx((byte)12);/* .. and allow for midnight */

/* Determine the phrase to use for each 5-minute segment    */
{/*select*/
if (min.OpEq(null,$011));/* add "o'clock" later */
else if (min.OpEq(null,$012))min=new netrexx.lang.Rexx((byte)0);/* ditto */
else if (min.OpEq(null,$06))out=out.OpCcblank(null,$013);
else if (min.OpEq(null,$014))out=out.OpCcblank(null,$015);
else if (min.OpEq(null,$016))out=out.OpCcblank(null,netrexx.lang.Rexx.toRexx("a quarter past"));
else if (min.OpEq(null,$017))out=out.OpCcblank(null,netrexx.lang.Rexx.toRexx("twenty past"));
else if (min.OpEq(null,$018))out=out.OpCcblank(null,netrexx.lang.Rexx.toRexx("twenty-five past"));
else if (min.OpEq(null,$019))out=out.OpCcblank(null,$020);
else if (min.OpEq(null,$021))out=out.OpCcblank(null,netrexx.lang.Rexx.toRexx("twenty-five to"));
else if (min.OpEq(null,$022))out=out.OpCcblank(null,$023);
else if (min.OpEq(null,$024))out=out.OpCcblank(null,netrexx.lang.Rexx.toRexx("a quarter to"));
else if (min.OpEq(null,$025))out=out.OpCcblank(null,$026);
else if (min.OpEq(null,$027))out=out.OpCcblank(null,$028);
else{throw new netrexx.lang.NoOtherwiseException();}}

numbers=netrexx.lang.Rexx.toRexx("one two three four five six").OpCcblank(null,netrexx.lang.Rexx.toRexx("seven eight nine ten eleven twelve "));/* (continuation) */

out=out.OpCcblank(null,numbers.word(hour));/* add the hour number */
if (min.OpEq(null,$011)) out=out.OpCcblank(null,$029);return;}/* .. and o'clock if exact */


/* Mike Cowlishaw,  December 1979 - January 1985            */
/* NetRexx version March 1996                               */

public static void main(java.lang.String args[]){com.rvjansen.qtime q;
q=new com.rvjansen.qtime();
netrexx.lang.RexxIO.Say(q.getOut());return;}public netrexx.lang.Rexx getOut(){return out;}public void setOut(netrexx.lang.Rexx $3){out=$3;return;}}
