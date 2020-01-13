package com.cognizant.moviecruiser.dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImplTest {

	public static void testGetMoviesListAdmin() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListAdmin();
		System.out.format("%-10s%-20s%-15s%-10s%-20s%-20s%-10s", "ID", "NAME", "GROSS", "ACTIVE", "DATE_OF_LAUNCH",
				"GENRE", "HAS_TEASER");
		System.out.println();
		for (Movies movies : moviesList) {
			String active, hasTeaser;
			if (movies.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies.getTeaser() == true) {
				hasTeaser = "Yes";
			} else {
				hasTeaser = "No";
			}
			System.out.format("%-10s%-20s%-15s%-10s%-20s%-20s%-10s", movies.getId(), movies.getTitle(),
					movies.getGross(), active, sdf.format(movies.getDateOfLaunch()), movies.getGenre(), hasTeaser);
			System.out.println();
		}
	}

	public static void testGetMoviesListCustomer() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ArrayList<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListCustomer();
		System.out.format("%-10s%-20s%-15s%-10s%-20s%-20s%-10s", "ID", "NAME", "GROSS", "ACTIVE", "DATE_OF_LAUNCH",
				"GENRE", "HAS_TEASER");
		System.out.println();
		for (Movies movies : moviesList) {
			String active, hasTeaser;
			if (movies.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies.getTeaser() == true) {
				hasTeaser = "Yes";
			} else {
				hasTeaser = "No";
			}
			System.out.format("%-10s%-20s%-15s%-10s%-20s%-20s%-10s", movies.getId(), movies.getTitle(),
					movies.getGross(), active, sdf.format(movies.getDateOfLaunch()), movies.getGenre(), hasTeaser);
			System.out.println();
		}
	}

	public static void testModifyMovies() throws NumberFormatException, IOException {
		Movies item = new Movies(1L, "Avatar", 2787965087l, true, new DateUtil().convertToDate("15/03/2017"),
				"Science Fiction", true);
		MoviesDaoSqlImpl moviesDaoSqlImpl = new MoviesDaoSqlImpl();
		moviesDaoSqlImpl.modifyMovies(item);
		testGetMoviesListAdmin();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		testGetMoviesListAdmin();
		testGetMoviesListCustomer();
		testModifyMovies();

	}

}
