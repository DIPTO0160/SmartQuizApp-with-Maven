package com.mycompany.smartquizapp.service;

import com.mycompany.smartquizapp.model.QuizCategory;
import com.mycompany.smartquizapp.model.QuizQuestion;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public final class QuizRepository {

    private static final Map<QuizCategory, List<QuizQuestion>> QUESTIONS = new EnumMap<>(QuizCategory.class);

    static {
        QUESTIONS.put(QuizCategory.GENERAL_KNOWLEDGE, Collections.unmodifiableList(Arrays.asList(
                q(1, "What is the capital city of Canada?", "Toronto", "Ottawa", "Vancouver", "Montreal", "Ottawa"),
                q(2, "Which desert is the largest hot desert in the world?", "Gobi", "Sahara", "Kalahari", "Arabian", "Sahara"),
                q(3, "Which country is home to the Great Pyramid of Giza?", "Jordan", "Egypt", "Greece", "Mexico", "Egypt"),
                q(4, "The United Nations headquarters is located in which city?", "Geneva", "Paris", "New York City", "Brussels", "New York City"),
                q(5, "Which ocean lies between Africa and Australia?", "Atlantic Ocean", "Arctic Ocean", "Indian Ocean", "Pacific Ocean", "Indian Ocean"),
                q(6, "Mount Kilimanjaro is located in which country?", "Kenya", "Ethiopia", "Tanzania", "Uganda", "Tanzania"),
                q(7, "Who wrote the Declaration of Independence of the United States?", "George Washington", "Benjamin Franklin", "Thomas Jefferson", "John Adams", "Thomas Jefferson"),
                q(8, "Which country gifted the Statue of Liberty to the United States?", "France", "Spain", "Italy", "Germany", "France"),
                q(9, "What is the smallest country in the world by area?", "Monaco", "San Marino", "Vatican City", "Liechtenstein", "Vatican City"),
                q(10, "Which river flows through Baghdad?", "Nile", "Tigris", "Euphrates", "Jordan", "Tigris"),
                q(11, "Which continent has the most countries?", "Asia", "Europe", "South America", "Africa", "Africa"),
                q(12, "In which country would you find Machu Picchu?", "Peru", "Chile", "Bolivia", "Ecuador", "Peru"),
                q(13, "Which nation is known as the Land of the Rising Sun?", "China", "South Korea", "Japan", "Thailand", "Japan"),
                q(14, "Who was the first woman to fly solo across the Atlantic Ocean?", "Valentina Tereshkova", "Amelia Earhart", "Sally Ride", "Bessie Coleman", "Amelia Earhart"),
                q(15, "What is the official currency of Japan?", "Won", "Yuan", "Yen", "Ringgit", "Yen"),
                q(16, "Which country hosted the 2016 Summer Olympics?", "China", "Brazil", "United Kingdom", "Russia", "Brazil"),
                q(17, "Which wall historically divided Berlin from 1961 to 1989?", "Iron Wall", "German Wall", "Berlin Wall", "Cold War Wall", "Berlin Wall"),
                q(18, "Which is the longest river in South America?", "Parana", "Orinoco", "Magdalena", "Amazon", "Amazon"),
                q(19, "The ancient city of Petra is in which modern-day country?", "Egypt", "Jordan", "Lebanon", "Turkey", "Jordan"),
                q(20, "Which country has the maple leaf on its national flag?", "Canada", "Austria", "Denmark", "Finland", "Canada")
        )));

        QUESTIONS.put(QuizCategory.GENERAL_SCIENCE, Collections.unmodifiableList(Arrays.asList(
                q(1, "What is the chemical symbol for gold?", "Ag", "Au", "Gd", "Go", "Au"),
                q(2, "Which planet is known as the Red Planet?", "Mars", "Venus", "Mercury", "Jupiter", "Mars"),
                q(3, "What gas do plants absorb from the atmosphere during photosynthesis?", "Oxygen", "Nitrogen", "Carbon dioxide", "Helium", "Carbon dioxide"),
                q(4, "What part of the human body contains the smallest bones?", "Hand", "Ear", "Foot", "Nose", "Ear"),
                q(5, "How many chambers does the human heart have?", "2", "3", "4", "5", "4"),
                q(6, "What is H2O commonly known as?", "Hydrogen peroxide", "Water", "Salt", "Oxygen", "Water"),
                q(7, "Which branch of science studies living organisms?", "Geology", "Biology", "Astronomy", "Meteorology", "Biology"),
                q(8, "What force keeps planets in orbit around the sun?", "Magnetism", "Friction", "Gravity", "Pressure", "Gravity"),
                q(9, "Which vitamin is mainly produced when skin is exposed to sunlight?", "Vitamin A", "Vitamin B12", "Vitamin C", "Vitamin D", "Vitamin D"),
                q(10, "At what temperature does water boil at sea level?", "90 C", "100 C", "110 C", "120 C", "100 C"),
                q(11, "What is the center of an atom called?", "Electron", "Nucleus", "Proton shell", "Core ion", "Nucleus"),
                q(12, "Which organ pumps blood through the human body?", "Lung", "Liver", "Heart", "Kidney", "Heart"),
                q(13, "Which blood cells help fight infection?", "Red blood cells", "White blood cells", "Platelets", "Plasma cells", "White blood cells"),
                q(14, "The process of a liquid turning into gas is called what?", "Condensation", "Evaporation", "Freezing", "Melting", "Evaporation"),
                q(15, "Which planet has the most rings visible in our solar system?", "Mars", "Saturn", "Earth", "Neptune", "Saturn"),
                q(16, "What kind of energy is stored in food?", "Nuclear energy", "Chemical energy", "Sound energy", "Light energy", "Chemical energy"),
                q(17, "What is the pH of a neutral solution?", "0", "5", "7", "14", "7"),
                q(18, "Which scientist proposed the three laws of motion?", "Albert Einstein", "Isaac Newton", "Galileo Galilei", "Niels Bohr", "Isaac Newton"),
                q(19, "Which human organ is primarily responsible for filtering blood?", "Stomach", "Kidney", "Pancreas", "Skin", "Kidney"),
                q(20, "DNA stands for what?", "Dynamic Nucleic Acid", "Deoxyribonucleic Acid", "Double Ribose Nucleic Acid", "Digital Nucleic Array", "Deoxyribonucleic Acid")
        )));

        QUESTIONS.put(QuizCategory.TECHNOLOGY, Collections.unmodifiableList(Arrays.asList(
                q(1, "What does CPU stand for?", "Central Process Unit", "Central Processing Unit", "Computer Personal Unit", "Central Performance Utility", "Central Processing Unit"),
                q(2, "Which company developed the Android operating system?", "Apple", "Microsoft", "Google", "IBM", "Google"),
                q(3, "What does HTML stand for?", "HyperText Markup Language", "HighText Machine Language", "Hyperlinking Text Management Language", "Home Tool Markup Language", "HyperText Markup Language"),
                q(4, "Which device stores data permanently in a computer?", "RAM", "Cache", "Hard drive or SSD", "Register", "Hard drive or SSD"),
                q(5, "What does URL stand for?", "Uniform Resource Locator", "Universal Reference Link", "Uniform Retrieval Link", "User Resource Locator", "Uniform Resource Locator"),
                q(6, "Which company created the iPhone?", "Samsung", "Nokia", "Apple", "Sony", "Apple"),
                q(7, "What does Wi-Fi primarily provide?", "Battery charging", "Wireless internet connectivity", "Antivirus scanning", "Cloud storage", "Wireless internet connectivity"),
                q(8, "Which programming language is commonly used for web page styling?", "HTML", "Python", "CSS", "SQL", "CSS"),
                q(9, "What is phishing in cybersecurity?", "A firewall update", "A way to speed up internet", "A fraudulent attempt to steal information", "A data backup method", "A fraudulent attempt to steal information"),
                q(10, "Which key combination is commonly used to copy selected text on Windows?", "Ctrl + X", "Ctrl + C", "Ctrl + V", "Ctrl + Z", "Ctrl + C"),
                q(11, "What does SSD stand for?", "Solid State Drive", "Secure Storage Disk", "System Software Device", "Serial State Disk", "Solid State Drive"),
                q(12, "Which company owns the Windows operating system?", "Google", "Microsoft", "Apple", "Oracle", "Microsoft"),
                q(13, "What is the main purpose of a router?", "Print documents", "Store passwords", "Direct network traffic", "Compile code", "Direct network traffic"),
                q(14, "Which social platform is primarily focused on professional networking?", "Instagram", "TikTok", "LinkedIn", "Snapchat", "LinkedIn"),
                q(15, "What does AI stand for in technology?", "Automated Interface", "Artificial Intelligence", "Advanced Internet", "Applied Informatics", "Artificial Intelligence"),
                q(16, "Which file format is widely used for portable documents?", "MP3", "PDF", "PNG", "TXT", "PDF"),
                q(17, "What is the brain of the computer often called?", "GPU", "SSD", "CPU", "Motherboard", "CPU"),
                q(18, "Which protocol is used to transfer web pages on the internet?", "FTP", "HTTP", "SMTP", "SSH", "HTTP"),
                q(19, "What does USB stand for?", "Unified System Bus", "Universal Serial Bus", "Universal Storage Base", "User Serial Bridge", "Universal Serial Bus"),
                q(20, "Which programming language runs natively in web browsers for interactivity?", "Java", "C#", "JavaScript", "C++", "JavaScript")
        )));
    }

    private QuizRepository() {
    }

    private static QuizQuestion q(int id, String text, String optionA, String optionB,
            String optionC, String optionD, String answer) {
        return new QuizQuestion(id, text, Arrays.asList(optionA, optionB, optionC, optionD), answer);
    }

    public static List<QuizQuestion> getQuestions(QuizCategory category) {
        return QUESTIONS.get(category);
    }
}
