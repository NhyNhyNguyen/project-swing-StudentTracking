/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.BorderLayout;

/**
 *
 * @author qphan
 */
public class LayoutUtils {

    private static BorderLayout borderLayout;

    private LayoutUtils() {
        borderLayout = null;
    }

    public static synchronized BorderLayout getBorderLayoutInstance() {
        if (borderLayout == null) {
            borderLayout = new BorderLayout();
        }
        return borderLayout;
    }

}
