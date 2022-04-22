package classes;

/*
The aim of the assignment is to validate the published densities’ data of elements in the periodic table by cross
checking them with atomic data. Specifically, you are required to write a program that reads the atomic size of each
element and its atomic weight, calculate the density of a single atom (atomic weight/ atomic volume) and compare the
results with the tabulated density of the element (see second link). Note that each element has a theoretical and an
empirical size: Your calculation should be based on both.

You are further, required to calculate the distances between the atoms of a given element that would result in an
accurate estimation of the tabulated densities. The results that you obtain should be compared with the published
data for number of atoms per unit volume (see the second link).

Atomic radii data: https://en.wikipedia.org/wiki/Atomic_radii_of_the_elements_(data_page)
Density data with number of atoms per volume: https://en.wikipedia.org/wiki/Talk%3AList_of_elements_by_density/Numeric_densities
*/

import java.io.File;
import java.util.Scanner;

public class assignement
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(new File("src/files/AtomData.txt"));
		sc.nextLine(); //skip descriptive line

		final Object[][] table = new String[85][];
		table[0] = new String[]{ "NR" , "NAME" , "WEIGHT 10^-24g" , "THEORETHICAL DENSITY 10^24" , "EMPIRICAL DENSITY 10^24" , "WIKIPEDIE DENSITY g/cm^3" , "THEORETHICAL DISTANCE 10^-9" , "EMPIRICAL DISTANCE 10^-9" , "CALCULATED ZETTA" , "WIKIPEDIA ZETTA 10^-24" };
		for(int i = 1 ; i < table.length ; i++)
		{
			String newLine = sc.nextLine();
			if(!newLine.contains("-"))
			{
				String[] atomInfo = newLine.split(" ");
				int nr = Integer.parseInt(atomInfo[0]);
				String name = atomInfo[2];
				double wikipediaDensity = Double.parseDouble(atomInfo[6]);
				double wikipediaZetta = Double.parseDouble(atomInfo[7]);
				double weight = Double.parseDouble(atomInfo[3]) * Math.pow(10 , 24);
				double theorethicalRadii = Double.parseDouble(atomInfo[4]);
				double empiricalRadii = Double.parseDouble(atomInfo[5]);

				table[i] = new Atom(nr , name , weight , theorethicalRadii , empiricalRadii , wikipediaDensity , wikipediaZetta).toTable();
			}
		}
		for(final Object[] row : table)
		{
			System.out.format("%-5s%-15s%-18s%-30s%-25s%-30s%-30s%-30s%-20s%-25s\n" , row);
		}
	}
}





class Atom
{
	private final double avagadro = 6.022 * Math.pow(10 , 23); //avagadros constant = number of molecules in a mole

	private int nr; //atomic number
	private String name; //atomic name
	private double weight; //atomic weight

	private double theorethicalDensity; //density of a single atom
	private double theorethicalDistance; //density of a single atom

	private double empiricalDensity; //density of a single atom
	private double empiricalDistance; //density of a single atom

	private double calculatedZetta; //calculated zetta from wikipedias density
	private double wikipediaDensity; //density from wikipedia
	private double wikipediaZetta; //density from wikipedia



	/**
	 * @param nr                atomic number
	 * @param name              name
	 * @param weight            molar mass (weight of 6.022*10^23 atoms)
	 * @param theorethicalRadii in (pm = 10^-12m), theorethical radius of the atom
	 * @param empiricalRadii    in (pm = 10^-12m), empirical radius  of the atom
	 * @param wikipediaDensity  in (g/cm^3) given in wikipedia, density of the atom
	 */
	public Atom(int nr , String name , double weight , double theorethicalRadii , double empiricalRadii , double wikipediaDensity , double wikipediaZetta)
	{
		this.nr = nr;
		this.name = name;
		this.weight = weight / avagadro; //g

		//theorethical
		this.theorethicalDensity = density(this.weight , volume(theorethicalRadii)); //g/cm^3
		this.theorethicalDistance = distance(volume(theorethicalRadii));

		//empirical
		this.empiricalDensity = density(this.weight , volume(empiricalRadii)); //g/cm^3
		this.empiricalDistance = distance(volume(empiricalRadii));

		this.wikipediaDensity = wikipediaDensity; //g/cm^3
		this.calculatedZetta = zetta(this.wikipediaDensity);
		this.wikipediaZetta = wikipediaZetta;
	}



	/**
	 * @param weight
	 * @param volume
	 * @return density
	 */
	private double density(double weight , double volume)
	{
		return Math.pow(10 , -24) * weight / volume;
	}



	/**
	 * @return distance (radius) of the atoms to fit with the density given
	 */
	private double distance(double volume)
	{
		double threeVOverFourPi = (3 * volume) / (4 * Math.PI);
		return Math.pow(10 , 9) * Math.pow(threeVOverFourPi , (1.0 / 3));
	}



	private double zetta(double density)
	{
		return Math.pow(10 , 24) * 1 / volumeFromDensity(density) / Math.pow(10 , 21);
	}



	private double volumeFromDensity(double density)
	{
		return weight / density;
	}



	/**
	 * @param radii given in picometers (10^-12) - radius of the sphere/from otermost shell to center of the atom
	 * @return Volume of the sphere in cm^3
	 */
	private double volume(double radii)
	{
		//convert radius from picometer to cm
		radii = radii * Math.pow(10 , -10);
		//calculate volume (4*pi*r^3)/3)
		return (4 * Math.PI * Math.pow(radii , 3)) / 3;
	}



	public String[] toTable( )
	{
		String[] info = new String[10];
		info[0] = String.valueOf(nr);
		info[1] = name;
		info[2] = String.valueOf(round(weight));
		info[3] = String.valueOf(round(theorethicalDensity));
		info[4] = String.valueOf(round(empiricalDensity));
		info[5] = String.valueOf(wikipediaDensity);
		info[6] = String.valueOf(round(theorethicalDistance));
		info[7] = String.valueOf(round(empiricalDistance));
		info[8] = String.valueOf(round(calculatedZetta));
		info[9] = String.valueOf(wikipediaZetta);
		return info;
	}



	private double round(double d)
	{
		return 1.0 * Math.round(d * 10000) / 10000;
	}
}