/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robo;

import java.util.concurrent.RecursiveTask;

/**
 *
 * @author cc44984357886
 */
public class ContaCaminhos extends RecursiveTask<Integer> {
   
    private int n;
    private int m;
    private int cont;
    private int LIMITE =8;
    
    public ContaCaminhos(int n, int m ){
        this.n = n;
        this.m = m;
        cont = 0;
    }
   
    
    public static int contarCaminhos(int n, int m){
        if(n==0 && m==0) return 0;
        if (n==0 || m == 0) return 1;
        
        return (contarCaminhos(n-1,m)+contarCaminhos(n,m-1));
    }
    
    @Override
    protected Integer compute() {
        if(n<=LIMITE || m<=LIMITE){
            cont = contarCaminhos(n, m);
            return cont;
        }
        int x = n-1;
        int y = m-1;
        ContaCaminhos c1 = new ContaCaminhos(x,m);
        ContaCaminhos c2 = new ContaCaminhos(n,y);
        c1.fork();
        return c2.compute()+c1.join();
        /*a primeira tarefa é bifurcada enquanto o resultado da
        segunda é calculada (essa é a chamada recursiva até que a 
        condição do caso base seja atendida) e, depois disso, aguardamos
        o resultado da primeira tarefa.*/
    }
    
    
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    
    
}
