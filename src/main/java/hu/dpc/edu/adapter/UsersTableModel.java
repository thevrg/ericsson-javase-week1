package hu.dpc.edu.adapter;

import hu.dpc.edu.User;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by vrg on 12/10/16.
 */
public class UsersTableModel extends AbstractTableModel {

    private final static String[]columnNames = {"Username", "Last name", "First name"};
    private List<User> users;

    public UsersTableModel(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public void fireTableChangedEvent() {
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        final User user = users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return user.getUsername();
            case 1:
                return user.getLastName();
            case 2:
                return user.getFirstName();
        }
        return null;
    }
}
