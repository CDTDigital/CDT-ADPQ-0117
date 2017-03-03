package com.stanfieldsystems.web;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.support.StaticApplicationContext;
import com.stanfieldsystems.Category;

public class RetrievedCategories {

    public List<Category> getAllCategoriesFromCsv() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("categories.csv"));
        // read file line by line
        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<Category> listCategory = new ArrayList<Category>();
        while ((line = reader.readLine()) != null) {
            Category category = new Category();
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0) category.setName(data); else if (index == 1) category.setDescription(data); else System.out.println("invalid data::" + data);
                index++;
            }
            index = 0;
            listCategory.add(category);
        }
        reader.close();
        //System.out.println(listCategory);
        return listCategory;
    }
}
