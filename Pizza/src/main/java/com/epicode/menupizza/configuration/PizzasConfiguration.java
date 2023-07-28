package com.epicode.menupizza.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.epicode.menupizza.model.HawaiianPizza;
import com.epicode.menupizza.model.MargheritaPizza;
import com.epicode.menupizza.model.SalamiPizza;

@Configuration
public class PizzasConfiguration {

    @Bean("pizzaMargherita")
    @Scope("singleton")
    public MargheritaPizza margheritaPizza() {
        return new MargheritaPizza();
    }

    @Bean("pizzaHawaii")
    @Scope("singleton")
    public HawaiianPizza hawaiiPizza() {
        return new HawaiianPizza();
    }

    @Bean("pizzaSalami")
    @Scope("singleton")
    public SalamiPizza salamiPizza() {
        return new SalamiPizza();
    }
}


