/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deepspace;

/**
 *
 * @author david
 */
public interface SpaceFighter {
    float fire();
    float protection();
    ShotResult receiveShot(float shot);
}
