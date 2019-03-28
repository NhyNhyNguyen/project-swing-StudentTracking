/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import common.MenuEnum;
import java.util.Objects;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author qphan
 */
public class MenuDto {

    private MenuEnum menu;
    private JPanel panel;
    private JLabel label;

    public MenuDto() {
    }

    public MenuDto(final MenuEnum menu, final JPanel panel, final JLabel label) {
        this.menu = menu;
        this.panel = panel;
        this.label = label;
    }

    public MenuEnum getMenu() {
        return menu;
    }

    public void setMenu(MenuEnum menu) {
        this.menu = menu;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof MenuDto)) {
            return false;
        }
        final MenuDto dto = (MenuDto) o;
        return Objects.equals(menu, dto.getMenu());
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu);
    }

    @Override
    public String toString() {
        return "MenuDto{" + "menu=" + menu + ", panel=" + panel + ", label=" + label + '}';
    }
}
