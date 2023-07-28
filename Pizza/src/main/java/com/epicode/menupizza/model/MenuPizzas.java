package com.epicode.menupizza.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class MenuPizzas {
	private final List<MainPizza> pizzas = new ArrayList<MainPizza>();

}
