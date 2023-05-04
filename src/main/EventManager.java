package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import entity.Country;
import entity.Guest;
import entity.Hobby;
import entity.Language;

public class EventManager {
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);

		boolean flag= true;
		while(flag)
		{
			
			System.out.println("Press 1 for populate The guest");
			System.out.println("Press 2 for filter the guest");
			System.out.println("Press other keys for exit purpose ");
			int key= scan.nextInt();
		switch (key) {
		case 1:
			List<Guest> populateGuests = populateGuests();
			break;
		case 2:
			List<Guest> populateGuests1 = populateGuests();
			filterGuest(populateGuests1);

		default:
			System.out.println("You got excited!!!");
			flag=false;
			break;
		}	
		}
	}
		
		
	public static void filterGuest(List<Guest> guests) {
        // list of guests from Spain and love music and dance
        Predicate<Guest> patternSpainMusicDance = g ->
                Country.Spain.equals(g.getCountry()) && Hobby.Music.equals(g.getHobby()) && Hobby.Dance.equals(g.getHobby());
        guests.stream().filter(patternSpainMusicDance).forEach(System.out::println);

        // list of guests from Spain and love to drink and age above 18
        Predicate<Guest> patternSpainDrinkAge18 = g ->
                Country.Spain.equals(g.getCountry()) && Hobby.Drink.equals(g.getHobby()) && g.getAge() > 18;
        guests.stream().filter(patternSpainDrinkAge18).forEach(System.out::println);

        // list of guests from France and love playing sports
        Predicate<Guest> patternFranceSports = g ->
                Country.France.equals(g.getCountry()) && Hobby.WaterSports.equals(g.getHobby());
        guests.stream().filter(patternFranceSports).forEach(System.out::println);

        // number of guests of age above 70 years
        long numGuestsAge70Plus = guests.stream().filter(g -> g.getAge() > 70).count();
        System.out.println("Number of guests above 70 years old: " + numGuestsAge70Plus);

        // list of guests who speak Chinese and love to read
        Predicate<Guest> patternChineseRead = g ->
                Language.Chinese.equals(g.getLanguage()) && Hobby.Read.equals(g.getHobby());
        guests.stream().filter(patternChineseRead).forEach(System.out::println);
    }


	


		public static List<Guest> populateGuests(){
			
			Scanner scan= new Scanner(System.in);
			List<Guest> g= new ArrayList<>();
			System.out.println("Enter the number of bookies");
			int noOfBokiee= scan.nextInt();
			for (int i = 0; i < noOfBokiee; i++) {
				System.out.println("Enter details for Guest " + (i + 1) + ":");
	            scan.nextLine();
	            System.out.print("Name: ");
	            String name = scan.nextLine();

	            System.out.print("Date Of Birth (yyyy-mm-dd): ");
	            String dobStr = scan.nextLine();
	            LocalDate dob = LocalDate.parse(dobStr);

	            System.out.print("Country (USA, Spain, Germany, France, China): ");
	            Country country = Country.valueOf(scan.nextLine());

	            System.out.print("Language (English, Spanish, French, Chinese, German): ");
	            Language language = Language.valueOf(scan.nextLine());

	            System.out.print("Hobby (Eat, Drink, WaterSports, Dance, Travel, Read, Music): ");
	            Hobby hobby = Hobby.valueOf(scan.nextLine());

	            Guest guest = new Guest(name, dob, country, language, hobby);
	            g.add(guest);
	        }

	        return g;
				
			}

}
