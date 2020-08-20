package com.nit.hk.test;

import static com.nit.hk.NewsHashTagGenerator.getHashTags;

public class NewsHashTagGeneratorTest
{

    public static void main( String[] args )
    {
        //1. in output COMMA is adding to the last word which is not required
        //2. Here only call getHashTags method of NewsHashTagGenerator class because i have static imported this methods upper ,so i can direcly call the method , don't need class to mention 
        //3. Static methods of another class you can call in this way
        getHashTags( "How the Avocado Became the Fruit of the Global Trade" );
        getHashTags( "Why You Will Probably Pay More for Your Christmas Tree This Year" );
        getHashTags( "Hey Parents, Surprise, Fruit Juice Is Not Fruit" );
        //4. In below case it Visualizing and Science both should be output beacuse there are max 2 words are there
        getHashTags( "Visualizing Science" );

        // 5. And please don't commit bin folder,.settings folder , .classpath ,.prject . You can add to the .gitignore file by right clicking on respective file
        // 6. Please follow the coding standards and Always separate the code 
        //7. After Fixing all the bugs , you can remove my comments and push it
    }
}
