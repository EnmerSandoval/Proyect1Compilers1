package org.example.lexer;

import java.io.*;
import java_cup.runtime.*;import javax.swing.*;
import javax.swing.JOptionPane;

%%


%public
%class Lexer
%unicode
%line
%column
%cup

digit = [0-9]+
letter = [a-zA-Z]
lineTerminator = \r|\n|\r|n
spaceWhite = [  |\t|\f ] | {lineTerminator}
word = {letter}({letter} | {digit})+
comillas = "\""
%%


"NUEVO_SITIO_WEB"       {return new Symbol(Simbolos.NUEVO_SITIO_WEB, yycolumn, yyline, yytext());}
"ID"                    {return new Symbol(Simholos.ID, yycolumn, yyline, yytext());}
"USUARIO_CREACION"      {return new Symbol(Simbolos.USUARIO_CREACION, yycolumn, yyline, yytext());}
"FECHA_CREACION"        {return new Symbol(Simbolos.FECHA_CREACION, yycolumn, yyline, yytext());}
"FECHA_MODIFICACION"    {return new Symbol(Simbolos.FECHA_MODIFICACION, yycolumn, yyline, yytext());}
"USUARIO_MODIFICACION"  {return new Symbol(Simbolos.USUARIO_MODIFICACION, yycolumn, yyline, yytext());}
"BORRAR_SITIO_WEB"      {return new Symbol(Simbolos.BORRAR_SITIO_WEB, yycolumn, yyline, yytext());}
"NUEVA_PAGINA"          {return new Symbol(Simbolos.NUEVA_PAGINA, yycolumn, yyline, yytext());}
"TITULO"                {return new Symbol(Simbolos.TITULO, yycolumn, yyline, yytext());}
"SITIO"                 {return new Symbol(Simbolos.SITIO, yycolumn, yyline, yytext());}
"PADRE"                 {return new Symbol(Simbolos.PADRE, yycolumn, yyline, yytext());}
"MODIFICAR_PAGINA"      {return new Symbol(Simbolos.MODIFICAR_PAGINA, yycolumn, yyline, yytext());}
"BORRAR_PAGINA"         {return new Symbol(Simbolos.BORRAR_PAGINA, yycolumn, yyline, yytext());}
"PAGINA"                {return new Symbol(Simbolos.PAGINA, yycolumn, yyline, yytext());}
"CLASE"                 {return new Symbol(Simbolos.CLASE, yycolumn, yyline, yytext());}
"AGREGAR_COMPONENTE"    {return new Symbol(Simbolos.AGREGAR_COMPONENTE, yycolumn, yyline, yytext());}
"BORRAR_COMPONENTE"     {return new Symbol(Simbolos.BORRAR_COMPONENTE, yycolumn, yyline, yytext());}
"ACCION"                {return new Symbol(Simbolos.ACCION, yycolumn, yyline, yytext());}
"ACCIONES"              {return new Symbol(Simbolos.ACCIONES, yycolumn, yyline, yytext());}
"PARAMETRO"             {return new Symbol(Simbolos.PARAMETRO, yycolumn, yyline, yytext());}
"PARAMETROS"            {return new Symbol(Simbolos.PARAMETROS, yycolumn, yyline, yytext());}
"NOMBRE"                {return new Symbol(Simbolos.NOMBRE, yycolumn, yyline, yytext());}
"="                     {return new Symbol(Simbolos.IGUAL, yycolumn, yyline, yytext());}
"<"                     {return new Symbol(Simbolos.MENORQUE, yycolumn, yyline, yytext());}
">"                     {return new Symbol(Simbolos.MAYORQUE, yycolumn, yyline, yytext());}
"["                     {return new Symgol(Simbolos.CORCHETEA, yycolumn, yyline, yytext());}
"]"                     {return new Symbol(Simbolos.CORCHETEC, yycolumn, yyline, yytext());}
{comillas}              {return new Symbol(Simbolos.COMILLAS, yycolumn, yyline, yytext());}

{spaceWhite}       {}

.   {JOptionPane.showMessageDialog(this, "Ha ocurrido un error en la linea y columna " + yyline + " " + yycolumn +" en el token: " + yytext());}