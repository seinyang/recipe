package com.example.recipe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MSSQLConnectionTest {

    // MSSQL 서버 정보
    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=recipe;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sein";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        // JDBC 드라이버 로드
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("MSSQL JDBC Driver Loaded.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // 데이터베이스 연결
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            System.out.println("Connected to the database");

            // 쿼리 실행
            try (Statement statement = connection.createStatement()) {
                String sql = "select * from la";

                ResultSet resultSet = statement.executeQuery(sql);

                // 결과 출력
                while (resultSet.next()) {
                    // 결과 처리 예시 (실제로는 결과를 어떻게 처리할지에 따라 다름)
                    int itemId = resultSet.getInt("항목일련번호");
                    String category = resultSet.getString("카테고리");
                    String name = resultSet.getString("이름");
                    String resultImage = resultSet.getString("메인이미지");
                    System.out.println("ID: " + itemId + ", Category: " + category + ", Name: " + name + ", Image: " + resultImage);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
