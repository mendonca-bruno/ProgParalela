/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robo;

import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author cc44984357886
 */
public class main {
    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        int n=10,m=20;
        ForkJoinPool pool = new ForkJoinPool();
        ContaCaminhos c1 = new ContaCaminhos(n, m);        
        System.out.println("(Paralelo)Caminhos " + pool.invoke(c1));
        System.out.println("Tempo " +(System.currentTimeMillis()-st));
        st = System.currentTimeMillis();
        System.out.println("(Sequencial)Caminhos " +ContaCaminhos.contarCaminhos(n, m));
        System.out.println("Tempo " +(System.currentTimeMillis()-st));
    }
}
