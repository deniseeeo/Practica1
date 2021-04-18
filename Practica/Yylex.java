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


class Yylex {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NO_ANCHOR,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"48:9,25,24,48:2,47,48:18,47,40,23,21,26,45,48:2,27,28,44,42,35,43,36,41,20:" +
"10,34,33,39,38,37,48:2,22:26,29,26,30,48,46,48,15,14,3,18,6,19,22,12,1,22,1" +
"6,13,22,2,17,8,22,4,5,7,9,22,11,10,22:2,31,26,32,48:2,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,93,
"0,1,2,3,1:2,4,1:11,5,6,7,1:7,4,8,1:4,8:12,9,8,1,10,11,12,13,14,15,16,17,18," +
"19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43," +
"44,45,46,47,48,49,50,51,52,53")[0];

	private int yy_nxt[][] = unpackFromString(54,49,
"1,2,47,92,87,61,73,47,74,47:2,81,47:2,82,47:3,90,62,46,3,47,4,5,6,7,8,9,10," +
"11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,48,-1:50,47,63,47:16," +
"29,47,-1,47,-1:27,30:19,-1:2,30,-1:51,28,-1:21,28,-1:39,31,-1:48,32,-1:48,3" +
"3,-1:11,47:20,-1,47,-1:46,46,-1:29,47:6,34,47:13,-1,47,-1:27,47:3,35,47:16," +
"-1,47,-1:27,47:3,36,47:16,-1,47,-1:27,47:3,37,47:16,-1,47,-1:27,47:5,38,47:" +
"14,-1,47,-1:27,47:4,39,47:15,-1,47,-1:27,47:5,40,47:14,-1,47,-1:27,47:15,41" +
",47:4,-1,47,-1:27,47,42,47:18,-1,47,-1:27,47:11,43,47:8,-1,47,-1:27,47:6,44" +
",47:13,-1,47,-1:27,47:5,45,47:14,-1,47,-1:27,47:5,49,47:4,84,47:9,-1,47,-1:" +
"27,47:16,50,47:3,-1,47,-1:27,47:2,51,47:17,-1,47,-1:27,47:7,52,47:12,-1,47," +
"-1:27,47:4,53,47:15,-1,47,-1:27,47:6,54,47:13,-1,47,-1:27,47:12,55,47:7,-1," +
"47,-1:27,47:14,56,47:5,-1,47,-1:27,47:3,57,47:16,-1,47,-1:27,47:2,58,47:17," +
"-1,47,-1:27,47:12,59,47:7,-1,47,-1:27,47:8,60,47:11,-1,47,-1:27,47:9,64,47:" +
"2,65,47:7,-1,47,-1:27,47:8,66,47:11,-1,47,-1:27,67,47:19,-1,47,-1:27,47:5,6" +
"8,47:14,-1,47,-1:27,47:8,69,47:11,-1,47,-1:27,47:6,70,47:13,-1,47,-1:27,47:" +
"8,71,47:11,-1,47,-1:27,47,72,47:18,-1,47,-1:27,47:11,75,47:8,-1,47,-1:27,47" +
":3,76,47:16,-1,47,-1:27,47:6,77,47:13,-1,47,-1:27,78,47:19,-1,47,-1:27,47:1" +
"4,79,47:5,-1,47,-1:27,80,47:19,-1,47,-1:27,47:5,83,47:14,-1,47,-1:27,47:18," +
"85,47,-1,47,-1:27,47:6,86,47:13,-1,47,-1:27,47:5,88,47:14,-1,47,-1:27,47,89" +
",47:18,-1,47,-1:27,47:16,91,47:3,-1,47,-1:26");

	public Yytoken yylex ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

  { System.exit(0); }
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 0:
						{ System.out.println ("NUMERO");}
					case -2:
						break;
					case 1:
						
					case -3:
						break;
					case 2:
						{ System.out.println ("ID");}
					case -4:
						break;
					case 3:
						{ 
    System.out.println("error lexico en "  + yyline + "," + yychar + " No se reconoce " + yytext());
    yychar=0;
  }
					case -5:
						break;
					case 4:
						{ System.out.println ("COMILLA");}
					case -6:
						break;
					case 5:
						{ System.out.println ("SALTO DE LINEA");}
					case -7:
						break;
					case 6:
						{ System.out.println ("TABULACION");}
					case -8:
						break;
					case 7:
						{ System.out.println ("IDENTIFICADOR");}
					case -9:
						break;
					case 8:
						{ System.out.println ("PARENTESIS ABIERTO");}
					case -10:
						break;
					case 9:
						{ System.out.println ("PARENTESIS CERRADO");}
					case -11:
						break;
					case 10:
						{ System.out.println ("CORCHETE ABIERTO");}
					case -12:
						break;
					case 11:
						{ System.out.println ("CORCHETE CERRADO");}
					case -13:
						break;
					case 12:
						{ System.out.println ("LLAVE ABIERTA");}
					case -14:
						break;
					case 13:
						{ System.out.println ("LLAVE CERRADA");}
					case -15:
						break;
					case 14:
						{ System.out.println ("PUNTO Y COMA");}
					case -16:
						break;
					case 15:
						{ System.out.println ("DOS PUNTOS");}
					case -17:
						break;
					case 16:
						{ System.out.println ("COMA");}
					case -18:
						break;
					case 17:
						{ System.out.println ("PUNTO");}
					case -19:
						break;
					case 18:
						{ System.out.println ("MAYOR");}
					case -20:
						break;
					case 19:
						{ System.out.println ("IGUAL");}
					case -21:
						break;
					case 20:
						{ System.out.println ("MENOR");}
					case -22:
						break;
					case 21:
						{ System.out.println ("DIFERENCIA");}
					case -23:
						break;
					case 22:
						{ System.out.println ("DIVISION");}
					case -24:
						break;
					case 23:
						{ System.out.println ("SIGNO MAS");}
					case -25:
						break;
					case 24:
						{ System.out.println ("SIGNO MENOS");}
					case -26:
						break;
					case 25:
						{ System.out.println ("SIGNO POR");}
					case -27:
						break;
					case 26:
						{ System.out.println ("SIGNO DE PORCENTAJE");}
					case -28:
						break;
					case 27:
						{ System.out.println ("GUION BAJO ");}
					case -29:
						break;
					case 28:
						{ }
					case -30:
						break;
					case 29:
						{ System.out.println ("IF");}
					case -31:
						break;
					case 30:
						{ System.out.println ("COMENTARIO");}
					case -32:
						break;
					case 31:
						{ System.out.println ("MAYOR O IGUAL");}
					case -33:
						break;
					case 32:
						{ System.out.println ("IGUAL");}
					case -34:
						break;
					case 33:
						{ System.out.println ("MENOR O IGUAL");}
					case -35:
						break;
					case 34:
						{ System.out.println ("SET");}
					case -36:
						break;
					case 35:
						{ System.out.println ("FOR");}
					case -37:
						break;
					case 36:
						{ System.out.println ("INCR");}
					case -38:
						break;
					case 37:
						{ System.out.println ("EXPR");}
					case -39:
						break;
					case 38:
						{ System.out.println ("ELSE");}
					case -40:
						break;
					case 39:
						{ System.out.println ("PUTS");}
					case -41:
						break;
					case 40:
						{ System.out.println ("WHILE");}
					case -42:
						break;
					case 41:
						{ System.out.println ("BREAK");}
					case -43:
						break;
					case 42:
						{ System.out.println ("RETURN");}
					case -44:
						break;
					case 43:
						{ System.out.println ("SWITCH");}
					case -45:
						break;
					case 44:
						{ System.out.println ("DEFAULT");}
					case -46:
						break;
					case 45:
						{ System.out.println ("CONTINUE");}
					case -47:
						break;
					case 46:
						{ System.out.println ("NUMERO");}
					case -48:
						break;
					case 47:
						{ System.out.println ("ID");}
					case -49:
						break;
					case 48:
						{ 
    System.out.println("error lexico en "  + yyline + "," + yychar + " No se reconoce " + yytext());
    yychar=0;
  }
					case -50:
						break;
					case 49:
						{ System.out.println ("ID");}
					case -51:
						break;
					case 50:
						{ System.out.println ("ID");}
					case -52:
						break;
					case 51:
						{ System.out.println ("ID");}
					case -53:
						break;
					case 52:
						{ System.out.println ("ID");}
					case -54:
						break;
					case 53:
						{ System.out.println ("ID");}
					case -55:
						break;
					case 54:
						{ System.out.println ("ID");}
					case -56:
						break;
					case 55:
						{ System.out.println ("ID");}
					case -57:
						break;
					case 56:
						{ System.out.println ("ID");}
					case -58:
						break;
					case 57:
						{ System.out.println ("ID");}
					case -59:
						break;
					case 58:
						{ System.out.println ("ID");}
					case -60:
						break;
					case 59:
						{ System.out.println ("ID");}
					case -61:
						break;
					case 60:
						{ System.out.println ("ID");}
					case -62:
						break;
					case 61:
						{ System.out.println ("ID");}
					case -63:
						break;
					case 62:
						{ System.out.println ("ID");}
					case -64:
						break;
					case 63:
						{ System.out.println ("ID");}
					case -65:
						break;
					case 64:
						{ System.out.println ("ID");}
					case -66:
						break;
					case 65:
						{ System.out.println ("ID");}
					case -67:
						break;
					case 66:
						{ System.out.println ("ID");}
					case -68:
						break;
					case 67:
						{ System.out.println ("ID");}
					case -69:
						break;
					case 68:
						{ System.out.println ("ID");}
					case -70:
						break;
					case 69:
						{ System.out.println ("ID");}
					case -71:
						break;
					case 70:
						{ System.out.println ("ID");}
					case -72:
						break;
					case 71:
						{ System.out.println ("ID");}
					case -73:
						break;
					case 72:
						{ System.out.println ("ID");}
					case -74:
						break;
					case 73:
						{ System.out.println ("ID");}
					case -75:
						break;
					case 74:
						{ System.out.println ("ID");}
					case -76:
						break;
					case 75:
						{ System.out.println ("ID");}
					case -77:
						break;
					case 76:
						{ System.out.println ("ID");}
					case -78:
						break;
					case 77:
						{ System.out.println ("ID");}
					case -79:
						break;
					case 78:
						{ System.out.println ("ID");}
					case -80:
						break;
					case 79:
						{ System.out.println ("ID");}
					case -81:
						break;
					case 80:
						{ System.out.println ("ID");}
					case -82:
						break;
					case 81:
						{ System.out.println ("ID");}
					case -83:
						break;
					case 82:
						{ System.out.println ("ID");}
					case -84:
						break;
					case 83:
						{ System.out.println ("ID");}
					case -85:
						break;
					case 84:
						{ System.out.println ("ID");}
					case -86:
						break;
					case 85:
						{ System.out.println ("ID");}
					case -87:
						break;
					case 86:
						{ System.out.println ("ID");}
					case -88:
						break;
					case 87:
						{ System.out.println ("ID");}
					case -89:
						break;
					case 88:
						{ System.out.println ("ID");}
					case -90:
						break;
					case 89:
						{ System.out.println ("ID");}
					case -91:
						break;
					case 90:
						{ System.out.println ("ID");}
					case -92:
						break;
					case 91:
						{ System.out.println ("ID");}
					case -93:
						break;
					case 92:
						{ System.out.println ("ID");}
					case -94:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
