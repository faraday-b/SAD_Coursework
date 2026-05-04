package com.example.shareapp.client.ui;

import com.example.shareapp.domain.model.SharePrice;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GraphingUI extends JFrame implements IVisualise {

    public GraphingUI() {
        setTitle("Share Performance Graph");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void renderComparisonChart(String title, List<SharePrice> data) {
        // Create a new window for the graph
        JFrame frame = new JFrame(title);
        frame.setSize(600, 400);

        // Basic drawing logic
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (data == null || data.size() < 2) return;

                g.setColor(Color.BLUE);
                int width = getWidth();
                int height = getHeight();
                int xStep = width / (data.size() - 1);

                // Draw lines between points
                for (int i = 0; i < data.size() - 1; i++) {
                    int x1 = i * xStep;
                    int y1 = height - (int)(data.get(i).getPrice() % height);
                    int x2 = (i + 1) * xStep;
                    int y2 = height - (int)(data.get(i+1).getPrice() % height);
                    g.drawLine(x1, y1, x2, y2);
                }
            }
        };

        frame.add(panel);
        frame.setVisible(true);
        System.out.println("[UI] Window opened for: " + title);
    }

    @Override
    public void displayComparison(String text) {
        System.out.println("\n--- Comparison Summary ---\n" + text);
    }
}