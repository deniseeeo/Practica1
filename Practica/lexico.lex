import java.lang.System;

class Analex {
      public static void main(String argv[])
	throws java.io.IOException {
	Yylex yy = new Yylex(System.in);
	while (yy.yylex() != null) {}	
    }
}

class Yytoken {
  Yytoken () {}
}
 
%%

%eofval{
  { System.exit(0); }
%eofval}

%line    
%char  

NUMERO = [0-9]*
LETRA=[a-zA-Z]
ID = [a-zA-Z]([a-zA-Z]|[0-9])*
COMILLA = [\"]
LINEA = [\n]
TAB = [\t]
IDENTIFICADOR= [\$|\\]



%%
 
 
 

<YYINITIAL> "incr" 		{ System.out.println ("INCR");}
<YYINITIAL> "set" 		{ System.out.println ("SET");}
<YYINITIAL> "puts" 		{ System.out.println ("PUTS");}
<YYINITIAL> "expr" 		{ System.out.println ("EXPR");}
<YYINITIAL> "switch" { System.out.println ("SWITCH");}
<YYINITIAL> "while"     { System.out.println ("WHILE");}
<YYINITIAL> "break" 	{ System.out.println ("BREAK");}
<YYINITIAL> "continue" 	{ System.out.println ("CONTINUE");}
<YYINITIAL> "default" 	{ System.out.println ("DEFAULT");}
<YYINITIAL> "else" 		{ System.out.println ("ELSE");}
<YYINITIAL> "for" 		{ System.out.println ("FOR");}
<YYINITIAL> "if" 		{ System.out.println ("IF");}
<YYINITIAL> "return"	{ System.out.println ("RETURN");}

<YYINITIAL> {NUMERO} 	{ System.out.println ("NUMERO");} 
<YYINITIAL> \#{LETRA}	{ System.out.println ("COMENTARIO");}
<YYINITIAL> {ID}       { System.out.println ("ID");}
<YYINITIAL> {COMILLA} 	{ System.out.println ("COMILLA");}
<YYINITIAL> {LINEA} 	{ System.out.println ("SALTO DE LINEA");}
<YYINITIAL> {TAB} 	{ System.out.println ("TABULACION");}
<YYINITIAL> {IDENTIFICADOR} 		{ System.out.println ("IDENTIFICADOR");}

<YYINITIAL> "(" 		{ System.out.println ("PARENTESIS ABIERTO");}
<YYINITIAL> ")" 		{ System.out.println ("PARENTESIS CERRADO");}
<YYINITIAL> "[" 		{ System.out.println ("CORCHETE ABIERTO");}
<YYINITIAL> "]" 		{ System.out.println ("CORCHETE CERRADO");}
<YYINITIAL> "{" 		{ System.out.println ("LLAVE ABIERTA");}
<YYINITIAL> "}" 		{ System.out.println ("LLAVE CERRADA");}
<YYINITIAL> ";" 		{ System.out.println ("PUNTO Y COMA");}
<YYINITIAL> ":" 		{ System.out.println ("DOS PUNTOS");}
<YYINITIAL> "," 		{ System.out.println ("COMA");}
<YYINITIAL> "." 		{ System.out.println ("PUNTO");}
<YYINITIAL> ">" 		{ System.out.println ("MAYOR");}
<YYINITIAL> ">=" 		{ System.out.println ("MAYOR O IGUAL");}
<YYINITIAL> "<" 		{ System.out.println ("MENOR");}
<YYINITIAL> "<=" 		{ System.out.println ("MENOR O IGUAL");}
<YYINITIAL> "=="		{ System.out.println ("IGUAL");}
<YYINITIAL> "="	  	{ System.out.println ("IGUAL");}
<YYINITIAL> "!" 		{ System.out.println ("DIFERENCIA");}
<YYINITIAL> "/" 		{ System.out.println ("DIVISION");}
<YYINITIAL> "+" 		{ System.out.println ("SIGNO MAS");}
<YYINITIAL> "-" 		{ System.out.println ("SIGNO MENOS");}
<YYINITIAL> "*" 		{ System.out.println ("SIGNO POR");}
<YYINITIAL> "/" 		{ System.out.println ("SIGNO DE DIVISION");}
<YYINITIAL> "%"			{ System.out.println ("SIGNO DE PORCENTAJE");}
<YYINITIAL> "_"			{ System.out.println ("GUION BAJO ");}


<YYINITIAL> [\n] 		{yychar=0;}
<YYINITIAL>  (" "|\r|\t)+	{ }

.
  { 
    System.out.println("error lexico en "  + yyline + "," + yychar + " No se reconoce " + yytext());
    yychar=0;
  }
  
  
 
  
  