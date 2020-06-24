/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Debora Freire
 */
public class model_pessoa {
    private float peso;
    private float altura;
    private float imc;

    public model_pessoa() {
    }

    
    public model_pessoa(float peso, float altura, float imc) {
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }
    
    
    
}
