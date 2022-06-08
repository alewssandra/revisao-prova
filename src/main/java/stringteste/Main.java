/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stringteste;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Aluno
 */
public class Main {
    public static void main(String[] args) {
        String nome = "Renato";
        System.out.println(nome);
        System.out.println(StringUtils.leftPad(nome, 20, "#"));
        System.out.println(StringUtils.rightPad(nome, 20, "#"));
        System.out.println(StringUtils.center(nome, 20, "#"));
        String[] lista = {"A", "B", "C", "D"};
        System.out.println(StringUtils.join(lista, ", "));
        
    }
}
