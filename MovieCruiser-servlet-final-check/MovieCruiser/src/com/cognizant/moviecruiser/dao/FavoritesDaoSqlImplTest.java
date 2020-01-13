package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImplTest {

	public static void testAddFavoritesMovie() throws FavoritesEmptyException {
		long userId = 1l;
		new FavoritesDaoSqlImpl().addFavoritesMovie(userId, 4);
		testGetAllFavoritesMovies();
	}

	public static void testGetAllFavoritesMovies() throws FavoritesEmptyException {
		List<Movies> list = new ArrayList<>();
		long userId = 1l;
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		Favorites obj = favoritesDaoSqlImpl.getAllFavoritesMovies(userId);
		list = obj.getMoviesList();
		System.out.format("%-10s%-20s%-20s%-15s", "ID", "TITLE", "GROSS", "GENRE");
		for (Movies movies : list) {
			System.out.format("\n%-10s%-20s%-20s%-15s", movies.getId(), movies.getTitle(), movies.getGross(),
					movies.getGenre());
		}
		System.out.println("\nNo.Of Favorites :" + obj.getTotal());
	}

	public static void testRemoveFavoritesMovies() throws FavoritesEmptyException {
		long userId = 1l;
		new FavoritesDaoSqlImpl().removeFavoritesMovie(userId, 4);
		testGetAllFavoritesMovies();
	}

	public static void main(String[] args) throws FavoritesEmptyException {
		testAddFavoritesMovie();
		testRemoveFavoritesMovies();
	}

}
