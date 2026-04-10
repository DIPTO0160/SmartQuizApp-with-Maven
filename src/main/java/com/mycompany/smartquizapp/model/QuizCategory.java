package com.mycompany.smartquizapp.model;

public enum QuizCategory {
    GENERAL_KNOWLEDGE("general-knowledge", "General Knowledge of the World",
            "World capitals, history, geography, institutions and current foundational facts.",
            "/WEB-INF/views/quizzes/general-knowledge.jsp"),
    GENERAL_SCIENCE("general-science", "General Science",
            "Physics, chemistry, biology and core scientific principles.",
            "/WEB-INF/views/quizzes/general-science.jsp"),
    TECHNOLOGY("technology", "Technology",
            "Computers, internet, software, hardware and major technology concepts.",
            "/WEB-INF/views/quizzes/technology.jsp");

    private final String slug;
    private final String title;
    private final String description;
    private final String viewPath;

    QuizCategory(String slug, String title, String description, String viewPath) {
        this.slug = slug;
        this.title = title;
        this.description = description;
        this.viewPath = viewPath;
    }

    public String getSlug() {
        return slug;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getViewPath() {
        return viewPath;
    }

    public static QuizCategory fromSlug(String slug) {
        for (QuizCategory category : values()) {
            if (category.slug.equals(slug)) {
                return category;
            }
        }
        return null;
    }
}
