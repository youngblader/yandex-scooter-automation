package models;

public record OrderData(
        String name,
        String surname,
        String address,
        String subway,
        String phone,
        String date,
        String period,
        Color color,
        String comment) {}