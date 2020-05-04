/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_bd.table;

import crud_bd.classes.Person;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author marco
 */
public class TableModel extends AbstractTableModel {

    private List<Person> dados = new ArrayList<>();
    private String colunas[] = {"Nome", "E-mail", "Telefone", "Idade"};
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0: return dados.get(rowIndex).getName();
            case 1: return dados.get(rowIndex).getEmail().equals("null")? "" : dados.get(rowIndex).getEmail();
            case 2: return dados.get(rowIndex).getPhoneNumber().equals("null")? "" : dados.get(rowIndex).getPhoneNumber();
            case 3: return dados.get(rowIndex).getAge();
            default: return null;
        }
    }

    @Override
    public void setValueAt(Object p, int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: dados.get(rowIndex).setName((String)p); break;
            case 1: dados.get(rowIndex).setEmail((String)p); break;
            case 2: dados.get(rowIndex).setPhoneNumber((String)p); break;
            case 3: dados.get(rowIndex).setAge((Integer)p); break;
        }
        this.fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    public void addPerson(Person p){
        this.dados.add(p);
        this.fireTableDataChanged();
    }
    
    public Person getPersonIndex(int rowIndex){
        return this.dados.get(rowIndex);
    }

}
