package tree;

import java.util.ArrayList;
import java.util.LinkedList;


import main.City;

public class BuildTree {
	
	private static final int ALTITUDE_INDEX = 2;// nell'array coordinate l'altitudine è nell'indice2
	private static final int Y_COORD_INDEX = 1;// nell'array coordinate la x è nell'indice 1
	private static final int X_COORD_INDEX = 0;// nell'array coordinate la y è nell'indice 0
	
	/**
	 * metodo che costruisce l'albero partendo dalle citta
	 * i nodi dell'albero sono memorizzati in una linkedList
	 * 
	 * inoltre è possibile decidere per quale squadra generare i pesi attraverso la variabile isTonatiuh
	 * @param allCity
	 * @param isTonatiuh (selettore di squadra)
	 * @return albero
	 */
	public static LinkedList<City>  buildTree(ArrayList<City> allCity, boolean isTonatiuh){
		 LinkedList<City> tree = new LinkedList<City>();//costeuisce un albero vuoto
		for(City city : allCity) tree.add(city);//aggiunge tutte le citta
		//per ogni nodo aggiunge i collegamenti ad altre
		for(City city : tree) {
			for(int id : city.getLinkTo()) {//controlla l'id
				for(City toCity : tree) {//se trova la citta con l'id corrispondente aggiunge il collegamento
					if(id == toCity.getId() && isTonatiuh) {
						city.addLink(toCity, getDistance_Tonatiuh(city, toCity));//peso se si sceglie Tonatiuh
						break;
					}
					else if	(id == toCity.getId() && !isTonatiuh) {
						city.addLink(toCity, getDistance_Metztli(city, toCity));//peso se si sceglie Metztli
						break;
					}
					
				}
			}
		}
		return tree;
	}
	/**
	 * metodo per generare la distanza tra due citta per il  team Tonatiuh
	 * usando la distanza euclidea
	 * @param fromCity
	 * @param toCity
	 * @return
	 */
	private static double getDistance_Tonatiuh(City fromCity, City toCity) {
		double distance=0;
		//formula distanza euclidea
		distance=Math.sqrt(Math.pow(fromCity.getCoords()[X_COORD_INDEX]-toCity.getCoords()[X_COORD_INDEX], 2)+ Math.pow(fromCity.getCoords()[Y_COORD_INDEX]-toCity.getCoords()[Y_COORD_INDEX], 2));
		return distance;
	}
	/**
	 * metodo per generare la distanza tra due citta per il  team Metztli
	 * usando il modulo della differenza tra l'altitudine
	 * @param fromCity
	 * @param toCity
	 * @return
	 */
	private static double getDistance_Metztli(City fromCity, City toCity) {
		double distance=0;
		distance=Math.abs(fromCity.getCoords()[ALTITUDE_INDEX]-toCity.getCoords()[ALTITUDE_INDEX]);
		return distance;
	}

}
