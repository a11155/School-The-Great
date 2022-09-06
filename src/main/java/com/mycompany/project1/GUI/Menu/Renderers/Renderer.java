/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.project1.GUI.Menu.Renderers;

import java.util.ArrayList;

/**
 *
 * @author Andrii
 */
public interface Renderer<T> {
    public T render(String name, ArrayList<T> arr);
}
