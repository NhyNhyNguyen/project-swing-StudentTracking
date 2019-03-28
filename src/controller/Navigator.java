/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.MenuEnum;
import dto.MenuDto;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JPanel;
import utils.ColorUtils;
import utils.LayoutUtils;
import view.PnCourseManager;
import view.PnHomePage;
import view.PnStudentManager;

/**
 *
 * @author qphan
 */
public class Navigator {

    private final JPanel pnMainView;
    private List<MenuDto> menus;
    private MenuEnum pressedMenu;

    public Navigator(final JPanel pnMainView) {
        this.pnMainView = pnMainView;
    }

    /**
     * Display HomePage panel in the first entering.
     *
     * @param panel current panel
     */
    public void viewPage(final JPanel panel) {

        pressedMenu = MenuEnum.HomePage;

        pnMainView.removeAll();
        pnMainView.setLayout(LayoutUtils.getBorderLayoutInstance());
        pnMainView.add(panel, BorderLayout.CENTER);

        pnMainView.validate();
        pnMainView.repaint();
    }

    public void addEventListeners(final List<MenuDto> menus) {
        this.menus = menus;
        menus.forEach((menu) -> {
            menu.getLabel().addMouseListener(new LabelMenuEvent(menu));
        });
    }

    class LabelMenuEvent extends MouseAdapter {

        private JPanel selectedPanel;

        private final MenuEnum menu;
        private final JPanel menuPanel;

        public LabelMenuEvent(final MenuDto menu) {
            this.menu = menu.getMenu();
            this.menuPanel = menu.getPanel();

        }

        @Override
        public void mousePressed(MouseEvent e) {
            pressedMenu = menu;
            switch (menu) {
                case HomePage:
                    selectedPanel = new PnHomePage();
                    break;
                case StudentManager:
                    selectedPanel = new PnStudentManager();
                    break;
                case CourseManager:
                    selectedPanel = new PnCourseManager();
                    break;
            }
            pnMainView.removeAll();
            pnMainView.setLayout(LayoutUtils.getBorderLayoutInstance());
            pnMainView.add(selectedPanel, BorderLayout.CENTER);

            pnMainView.validate();
            pnMainView.repaint();

            // setBackground
            menus.forEach(menu -> menu.getPanel().setBackground(ColorUtils.menuPanel));
            menuPanel.setBackground(ColorUtils.menuPanelHover);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            menuPanel.setBackground(ColorUtils.menuPanelHover);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (pressedMenu != menu) {
                menuPanel.setBackground(ColorUtils.menuPanel);
            }
        }
    }

}
