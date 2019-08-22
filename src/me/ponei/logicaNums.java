/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.ponei;

/**
 *
 * @author s.lucas
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class logicaNums {

    //utils
    ArrayList<Integer> listaNums = new ArrayList<Integer>();

    public logicaNums() {

    }

    public boolean indexcheck(int index) {
        if (listaNums.isEmpty() || (index > listaNums.size()) || 0 >= index) {
            return false;
        } else {
            return true;
        }
    }

    //logica pro form
    public boolean salvar(int num) {
        if ((num % 2) != 0) {
            listaNums.add(num);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "isto nao e impar");
            return false;
        }
    }

    public String listar() {
        String r = "lista completa\n";
        if (!listaNums.isEmpty()) {
            for (int i = 0; i < listaNums.size(); i++) {
                r += "[" + (1 + i) + "]: " + listaNums.get(i) + "\n";

            }
        } else {
            r = "sua lista esta vazia";
        }
        return r;
    }

    public String limpar() {
        listaNums.clear();
        return "sua lista esta vazia";
    }

    public void buscar(int index) {
        if (!indexcheck(index)) {
            JOptionPane.showMessageDialog(null, "numero inexistente");
        } else {
            JOptionPane.showMessageDialog(null, "numero: " + listaNums.get(index - 1));
        }
    }

    public void quantidade() {
        JOptionPane.showMessageDialog(null, "esta lista contem " + listaNums.size() + " numero(s)");
    }

    public boolean remover(int index) {
        if (!indexcheck(index)) {
            JOptionPane.showMessageDialog(null, "numero inexistente");
            return false;
        } else {
            listaNums.remove(index - 1);
            return true;
        }
    }

    public boolean editar(int index) {
        if (!indexcheck(index)) {
            JOptionPane.showMessageDialog(null, "numero inexistente");
            return false;
        } else {
            int novonum = 0;
            String novonumstr = JOptionPane.showInputDialog(null, "digite o novo numero", "editando o item numero [" + index + "]: \"" + listaNums.get(index - 1) + "\"", JOptionPane.INFORMATION_MESSAGE);
            try {
                novonum = Integer.parseInt(novonumstr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "novo numero e invalido");
                return false;
            }

            if ((novonum % 2) != 0) {
                listaNums.set(index - 1, novonum);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "novo numero nao e impar");
                return false;
            }
        }
    }

    public void gerartabuada3() {
        if (listaNums.size() >= 3) {
            int numtabuada = listaNums.get(2);
            String tabuada = "tabuada do numero " + numtabuada + ":\n\n";
            for (int i = 1; 10 >= i; i++) {
                tabuada += numtabuada + " * " + i + " = " + (numtabuada * i) + "\n";
            }
            JOptionPane.showMessageDialog(null, tabuada);
        } else {
            JOptionPane.showMessageDialog(null, "lista nao tem o item 3");
        }
    }

    public void verificar1() {
        if (listaNums.size() > 0) {
            int num = listaNums.get(0);
            if (num > 0) {
                JOptionPane.showMessageDialog(null, "numero " + num + " é positivo");
            } else {
                JOptionPane.showMessageDialog(null, "numero " + num + " é negativo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "lista esta vazia");
        }
    }
}
