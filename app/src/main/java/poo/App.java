package poo;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {
    
    private static final String HERO_IMAGE = "https://images.unsplash.com/photo-1544636331-e26879cd4d9b?w=1920&q=80";
    private static final String[] CAR_IMAGES = {
        "https://images.unsplash.com/photo-1503376780353-7e6692767b70?w=400&q=80",
        "https://images.unsplash.com/photo-1555215695-3004980ad54e?w=400&q=80",
        "https://images.unsplash.com/photo-1542362567-b07e54358753?w=400&q=80",
        "https://images.unsplash.com/photo-1552519507-da3b142c6e3d?w=400&q=80",
        "https://images.unsplash.com/photo-1583121274602-3e2820c69888?w=400&q=80",
        "https://images.unsplash.com/photo-1494976388531-d1058494cdd8?w=400&q=80"
    };
    private static final String[] SUV_IMAGES = {
        "https://images.unsplash.com/photo-1519641471654-76ce0107ad1b?w=400&q=80",
        "https://images.unsplash.com/photo-1606664515524-ed2f786a0bd6?w=400&q=80",
        "https://images.unsplash.com/photo-1533473359331-0135ef1b58bf?w=400&q=80",
        "https://images.unsplash.com/photo-1609521263047-f8f205293f24?w=400&q=80",
        "https://images.unsplash.com/photo-1606016159991-dfe4f2746ad5?w=400&q=80",
        "https://images.unsplash.com/photo-1581650107963-3e8c1f48241b?w=400&q=80"
    };
    private static final String[] TIPOS = {"Deportivo", "Sedan", "Coupe", "Luxury", "Classic", "Sport"};
    private static final String[] TIPOS_SUV = {"SUV", "Crossover", "4x4", "Premium", "Compact", "Full-Size"};
    private static final String[] PRECIOS = {"$45,000", "$38,500", "$52,000", "$78,000", "$42,000", "$55,000"};
    
    private double scrollOffset = 0;
    
    @Override
    public void start(Stage stage) {
        // Root con todo el contenido
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: #ffffff;");
        
        // ScrollPane principal
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        scrollPane.setPannable(true);
        
        // Contenedor del contenido
        VBox content = new VBox(0);
        content.setAlignment(Pos.TOP_CENTER);
        
        // === HERO SECTION ===
        StackPane hero = createHeroSection(stage);
        
        // === SECCIÓN FAVORITOS ===
        VBox favoritosSection = createCarsSection("Nuestros Favoritos", CAR_IMAGES, TIPOS, PRECIOS, true, stage);
        
        // === SECCIÓN SUV ===
        VBox suvSection = createCarsSection("Nuestros SUV", SUV_IMAGES, TIPOS_SUV, PRECIOS, false, stage);
        
        // === FOOTER ===
        VBox footer = createFooter(stage);
        
        content.getChildren().addAll(hero, favoritosSection, suvSection, footer);
        scrollPane.setContent(content);
        
        // === HEADER GLASSMORPHISM ===
        StackPane header = createGlassHeader(stage);
        StackPane.setAlignment(header, Pos.TOP_CENTER);
        
        root.getChildren().addAll(scrollPane, header);
        
        // Animación parallax del header
        scrollPane.vvalueProperty().addListener((obs, old, val) -> {
            scrollOffset = val.doubleValue();
            updateHeaderStyle(header, scrollOffset);
        });
        
        Scene scene = new Scene(root);
        scene.setFill(Color.WHITE);
        
        stage.setTitle("AutoPremium - Tu Nuevo Vehículo");
        stage.setScene(scene);
        stage.setMinWidth(380);
        stage.setMinHeight(600);
        stage.setWidth(1200);
        stage.setHeight(800);
        stage.show();
        
        // Animaciones de entrada
        playEntranceAnimations(header, content);
    }
    
    // ==================== HEADER GLASSMORPHISM ====================
    private StackPane createGlassHeader(Stage stage) {
        StackPane headerContainer = new StackPane();
        headerContainer.setMaxHeight(70);
        headerContainer.setPadding(new Insets(12, 0, 0, 0));
        headerContainer.setPickOnBounds(false);
        
        // Fondo glass
        Rectangle glass = new Rectangle();
        glass.setArcWidth(50);
        glass.setArcHeight(50);
        glass.setHeight(46);
        glass.setFill(Color.rgb(20, 20, 20, 0.75));
        glass.setStroke(Color.rgb(255, 255, 255, 0.1));
        glass.setStrokeWidth(1.5);
        
        // Blur effect
        BoxBlur blur = new BoxBlur(8, 8, 3);
        glass.setEffect(blur);
        
        // Contenido del header
        HBox nav = new HBox(35);
        nav.setAlignment(Pos.CENTER);
        nav.setPadding(new Insets(0, 45, 0, 45));
        
        Label logo = new Label("●");
        logo.setFont(Font.font("System", FontWeight.BOLD, 18));
        logo.setTextFill(Color.WHITE);
        
        HBox menuItems = new HBox(28);
        menuItems.setAlignment(Pos.CENTER);
        
        Label vehiculos = createNavItem("vehiculos");
        Label catalogo = createNavItem("catalogo");
        Label miPedido = createNavItem("Mi pedido");
        
        menuItems.getChildren().addAll(vehiculos, catalogo, miPedido);
        nav.getChildren().addAll(logo, menuItems);
        
        // Responsivo
        stage.widthProperty().addListener((o, old, w) -> {
            double width = w.doubleValue();
            double headerW = Math.min(420, Math.max(320, width * 0.4));
            glass.setWidth(headerW);
            nav.setPrefWidth(headerW);
            
            if (width < 600) {
                menuItems.setSpacing(18);
                nav.setPadding(new Insets(0, 25, 0, 25));
            } else {
                menuItems.setSpacing(28);
                nav.setPadding(new Insets(0, 45, 0, 45));
            }
        });
        
        glass.setWidth(380);
        nav.setPrefWidth(380);
        
        headerContainer.getChildren().addAll(glass, nav);
        return headerContainer;
    }
    
    private Label createNavItem(String text) {
        Label label = new Label(text);
        label.setFont(Font.font("SF Pro Display", FontWeight.MEDIUM, 14));
        label.setTextFill(Color.rgb(255, 255, 255, 0.9));
        label.setCursor(javafx.scene.Cursor.HAND);
        
        // Underline effect
        label.setOnMouseEntered(e -> {
            FadeTransition ft = new FadeTransition(Duration.millis(150), label);
            ft.setToValue(0.7);
            ft.play();
            label.setStyle("-fx-underline: true;");
        });
        
        label.setOnMouseExited(e -> {
            FadeTransition ft = new FadeTransition(Duration.millis(150), label);
            ft.setToValue(1.0);
            ft.play();
            label.setStyle("-fx-underline: false;");
        });
        
        return label;
    }
    
    private void updateHeaderStyle(StackPane header, double scroll) {
        Rectangle glass = (Rectangle) header.getChildren().get(0);
        if (scroll > 0.01) {
            glass.setFill(Color.rgb(10, 10, 10, 0.9));
            DropShadow shadow = new DropShadow(20, Color.rgb(0, 0, 0, 0.4));
            shadow.setInput(new BoxBlur(8, 8, 3));
            glass.setEffect(shadow);
        } else {
            glass.setFill(Color.rgb(20, 20, 20, 0.75));
            glass.setEffect(new BoxBlur(8, 8, 3));
        }
    }
    
    // ==================== HERO SECTION ====================
    private StackPane createHeroSection(Stage stage) {
        StackPane hero = new StackPane();
        hero.setMinHeight(700);
        hero.prefHeightProperty().bind(stage.heightProperty().multiply(0.92));
        
        // Background gradient
        Rectangle bg = new Rectangle();
        bg.widthProperty().bind(stage.widthProperty());
        bg.heightProperty().bind(hero.heightProperty());
        bg.setFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
            new Stop(0, Color.rgb(15, 15, 25)),
            new Stop(1, Color.rgb(8, 8, 15))
        ));
        
        // Hero image
        ImageView heroImg = new ImageView();
        heroImg.setPreserveRatio(false);
        heroImg.fitWidthProperty().bind(stage.widthProperty());
        heroImg.fitHeightProperty().bind(hero.heightProperty());
        heroImg.setOpacity(0.85);
        
        try {
            heroImg.setImage(new Image(HERO_IMAGE, true));
        } catch (Exception e) {}
        
        // Gradient overlay
        Rectangle overlay = new Rectangle();
        overlay.widthProperty().bind(stage.widthProperty());
        overlay.heightProperty().bind(hero.heightProperty());
        overlay.setFill(new LinearGradient(0, 0, 0.3, 1, true, CycleMethod.NO_CYCLE,
            new Stop(0, Color.rgb(0, 0, 0, 0.6)),
            new Stop(0.3, Color.rgb(0, 0, 0, 0.3)),
            new Stop(0.7, Color.rgb(0, 0, 0, 0.4)),
            new Stop(1, Color.rgb(0, 0, 0, 0.8))
        ));
        
        // Hero content
        VBox heroContent = new VBox(20);
        heroContent.setAlignment(Pos.CENTER_LEFT);
        heroContent.setPadding(new Insets(0, 50, 80, 50));
        heroContent.setMaxWidth(700);
        
        Label title = new Label("Tu Nuevo Vehiculo\na un paso");
        title.setFont(Font.font("Georgia", FontWeight.BOLD, 52));
        title.setTextFill(Color.WHITE);
        title.setLineSpacing(8);
        title.setEffect(new DropShadow(25, Color.rgb(0, 0, 0, 0.6)));
        
        Label subtitle = new Label("Descubre nuestra exclusiva colección de vehículos premium");
        subtitle.setFont(Font.font("SF Pro Display", FontWeight.NORMAL, 18));
        subtitle.setTextFill(Color.rgb(255, 255, 255, 0.85));
        subtitle.setWrapText(true);
        
        // CTA Button
        Button ctaBtn = new Button("Explorar Catálogo");
        ctaBtn.setFont(Font.font("SF Pro Display", FontWeight.BOLD, 15));
        ctaBtn.setTextFill(Color.BLACK);
        ctaBtn.setPadding(new Insets(16, 40, 16, 40));
        ctaBtn.setStyle("-fx-background-color: white; -fx-background-radius: 30; -fx-cursor: hand;");
        
        ctaBtn.setOnMouseEntered(e -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(200), ctaBtn);
            st.setToX(1.05);
            st.setToY(1.05);
            st.play();
            ctaBtn.setStyle("-fx-background-color: #f0f0f0; -fx-background-radius: 30; -fx-cursor: hand;");
        });
        
        ctaBtn.setOnMouseExited(e -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(200), ctaBtn);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
            ctaBtn.setStyle("-fx-background-color: white; -fx-background-radius: 30; -fx-cursor: hand;");
        });
        
        VBox.setMargin(ctaBtn, new Insets(15, 0, 0, 0));
        heroContent.getChildren().addAll(title, subtitle, ctaBtn);
        
        StackPane.setAlignment(heroContent, Pos.CENTER_LEFT);
        
        // Scroll indicator
        VBox scrollIndicator = createScrollIndicator();
        StackPane.setAlignment(scrollIndicator, Pos.BOTTOM_CENTER);
        StackPane.setMargin(scrollIndicator, new Insets(0, 0, 30, 0));
        
        // Responsive
        stage.widthProperty().addListener((o, old, w) -> {
            double width = w.doubleValue();
            if (width < 600) {
                title.setFont(Font.font("Georgia", FontWeight.BOLD, 32));
                subtitle.setFont(Font.font("SF Pro Display", FontWeight.NORMAL, 14));
                heroContent.setPadding(new Insets(0, 25, 60, 25));
            } else if (width < 900) {
                title.setFont(Font.font("Georgia", FontWeight.BOLD, 42));
                subtitle.setFont(Font.font("SF Pro Display", FontWeight.NORMAL, 16));
                heroContent.setPadding(new Insets(0, 40, 70, 40));
            } else {
                title.setFont(Font.font("Georgia", FontWeight.BOLD, 52));
                subtitle.setFont(Font.font("SF Pro Display", FontWeight.NORMAL, 18));
                heroContent.setPadding(new Insets(0, 60, 80, 60));
            }
        });
        
        hero.getChildren().addAll(bg, heroImg, overlay, heroContent, scrollIndicator);
        return hero;
    }
    
    private VBox createScrollIndicator() {
        VBox indicator = new VBox(8);
        indicator.setAlignment(Pos.CENTER);
        
        Label scrollText = new Label("Scroll");
        scrollText.setFont(Font.font("SF Pro Display", FontWeight.LIGHT, 12));
        scrollText.setTextFill(Color.rgb(255, 255, 255, 0.7));
        
        Line line = new Line(0, 0, 0, 25);
        line.setStroke(Color.rgb(255, 255, 255, 0.5));
        line.setStrokeWidth(1);
        
        // Animación bounce
        TranslateTransition bounce = new TranslateTransition(Duration.millis(800), indicator);
        bounce.setByY(8);
        bounce.setCycleCount(Animation.INDEFINITE);
        bounce.setAutoReverse(true);
        bounce.play();
        
        indicator.getChildren().addAll(scrollText, line);
        return indicator;
    }
    
    // ==================== CARS SECTION ====================
    private VBox createCarsSection(String titleText, String[] images, String[] tipos, String[] precios, boolean showBtn, Stage stage) {
        VBox section = new VBox(40);
        section.setAlignment(Pos.CENTER);
        section.setPadding(new Insets(80, 40, 60, 40));
        section.setStyle("-fx-background-color: #ffffff;");
        
        // Título
        Label title = new Label(titleText);
        title.setFont(Font.font("SF Pro Display", FontWeight.BOLD, 36));
        title.setTextFill(Color.rgb(20, 20, 20));
        
        // Grid de cards
        FlowPane grid = new FlowPane(20, 20);
        grid.setAlignment(Pos.CENTER);
        grid.setPrefWrapLength(1000);
        
        for (int i = 0; i < 6; i++) {
            VBox card = createCarCard(images[i], tipos[i], precios[i], stage);
            grid.getChildren().add(card);
        }
        
        section.getChildren().addAll(title, grid);
        
        if (showBtn) {
            Button verMas = createOutlineButton("Ver más vehículos");
            VBox.setMargin(verMas, new Insets(20, 0, 0, 0));
            section.getChildren().add(verMas);
        }
        
        // Responsive
        stage.widthProperty().addListener((o, old, w) -> {
            double width = w.doubleValue();
            if (width < 600) {
                title.setFont(Font.font("SF Pro Display", FontWeight.BOLD, 26));
                section.setPadding(new Insets(50, 20, 40, 20));
                grid.setHgap(15);
                grid.setVgap(15);
            } else if (width < 900) {
                title.setFont(Font.font("SF Pro Display", FontWeight.BOLD, 30));
                section.setPadding(new Insets(60, 30, 50, 30));
                grid.setHgap(18);
                grid.setVgap(18);
            } else {
                title.setFont(Font.font("SF Pro Display", FontWeight.BOLD, 36));
                section.setPadding(new Insets(80, 50, 60, 50));
                grid.setHgap(25);
                grid.setVgap(25);
            }
        });
        
        return section;
    }
    
    private VBox createCarCard(String imageUrl, String tipo, String precio, Stage stage) {
        VBox card = new VBox(0);
        card.setAlignment(Pos.TOP_CENTER);
        card.setStyle("-fx-background-color: #f8f8f8; -fx-background-radius: 16;");
        card.setMinWidth(160);
        card.setMaxWidth(200);
        card.setPrefWidth(180);
        
        // Contenedor de imagen
        StackPane imageBox = new StackPane();
        imageBox.setMinHeight(130);
        imageBox.setPrefHeight(140);
        imageBox.setStyle("-fx-background-radius: 16 16 0 0;");
        
        // Imagen
        ImageView img = new ImageView();
        img.setFitWidth(180);
        img.setFitHeight(130);
        img.setPreserveRatio(false);
        img.setStyle("-fx-background-radius: 16 16 0 0;");
        
        Rectangle clip = new Rectangle(180, 130);
        clip.setArcWidth(16);
        clip.setArcHeight(16);
        img.setClip(clip);
        
        try {
            img.setImage(new Image(imageUrl, true));
        } catch (Exception e) {}
        
        // Badge tipo
        Label badge = new Label(tipo);
        badge.setFont(Font.font("SF Pro Display", FontWeight.BOLD, 10));
        badge.setTextFill(Color.WHITE);
        badge.setPadding(new Insets(5, 12, 5, 12));
        badge.setStyle("-fx-background-color: rgba(0,0,0,0.85); -fx-background-radius: 20;");
        StackPane.setAlignment(badge, Pos.TOP_RIGHT);
        StackPane.setMargin(badge, new Insets(10, 10, 0, 0));
        
        imageBox.getChildren().addAll(img, badge);
        
        // Botón precio
        Button precioBtn = new Button(precio);
        precioBtn.setFont(Font.font("SF Pro Display", FontWeight.BOLD, 13));
        precioBtn.setTextFill(Color.WHITE);
        precioBtn.setMaxWidth(Double.MAX_VALUE);
        precioBtn.setPadding(new Insets(14, 20, 14, 20));
        precioBtn.setStyle("-fx-background-color: #0a0a0a; -fx-background-radius: 0 0 16 16; -fx-cursor: hand;");
        
        card.getChildren().addAll(imageBox, precioBtn);
        
        // Hover effect
        card.setOnMouseEntered(e -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(200), card);
            st.setToX(1.03);
            st.setToY(1.03);
            st.play();
            
            card.setEffect(new DropShadow(25, Color.rgb(0, 0, 0, 0.15)));
            precioBtn.setStyle("-fx-background-color: #1a1a1a; -fx-background-radius: 0 0 16 16; -fx-cursor: hand;");
        });
        
        card.setOnMouseExited(e -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(200), card);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
            
            card.setEffect(null);
            precioBtn.setStyle("-fx-background-color: #0a0a0a; -fx-background-radius: 0 0 16 16; -fx-cursor: hand;");
        });
        
        // Click effect
        precioBtn.setOnMousePressed(e -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(80), precioBtn);
            st.setToX(0.97);
            st.setToY(0.97);
            st.play();
        });
        
        precioBtn.setOnMouseReleased(e -> {
            ScaleTransition st = new ScaleTransition(Duration.millis(80), precioBtn);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
        });
        
        // Responsive
        stage.widthProperty().addListener((o, old, w) -> {
            double width = w.doubleValue();
            if (width < 500) {
                card.setPrefWidth(140);
                card.setMinWidth(130);
                img.setFitWidth(140);
                clip.setWidth(140);
            } else {
                card.setPrefWidth(180);
                card.setMinWidth(160);
                img.setFitWidth(180);
                clip.setWidth(180);
            }
        });
        
        return card;
    }
    
    private Button createOutlineButton(String text) {
        Button btn = new Button(text);
        btn.setFont(Font.font("SF Pro Display", FontWeight.SEMI_BOLD, 14));
        btn.setTextFill(Color.BLACK);
        btn.setPadding(new Insets(14, 45, 14, 45));
        btn.setStyle("-fx-background-color: transparent; -fx-border-color: #0a0a0a; -fx-border-width: 2; -fx-border-radius: 30; -fx-background-radius: 30; -fx-cursor: hand;");
        
        btn.setOnMouseEntered(e -> {
            btn.setStyle("-fx-background-color: #0a0a0a; -fx-border-color: #0a0a0a; -fx-border-width: 2; -fx-border-radius: 30; -fx-background-radius: 30; -fx-cursor: hand;");
            btn.setTextFill(Color.WHITE);
            ScaleTransition st = new ScaleTransition(Duration.millis(150), btn);
            st.setToX(1.03);
            st.setToY(1.03);
            st.play();
        });
        
        btn.setOnMouseExited(e -> {
            btn.setStyle("-fx-background-color: transparent; -fx-border-color: #0a0a0a; -fx-border-width: 2; -fx-border-radius: 30; -fx-background-radius: 30; -fx-cursor: hand;");
            btn.setTextFill(Color.BLACK);
            ScaleTransition st = new ScaleTransition(Duration.millis(150), btn);
            st.setToX(1.0);
            st.setToY(1.0);
            st.play();
        });
        
        return btn;
    }
    
    // ==================== FOOTER ====================
    private VBox createFooter(Stage stage) {
        VBox footer = new VBox(30);
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(60, 40, 40, 40));
        footer.setStyle("-fx-background-color: #0a0a0a;");
        
        // Logo
        Label logo = new Label("AutoPremium");
        logo.setFont(Font.font("Georgia", FontWeight.BOLD, 28));
        logo.setTextFill(Color.WHITE);
        
        // Links
        HBox links = new HBox(40);
        links.setAlignment(Pos.CENTER);
        
        String[] linkTexts = {"Inicio", "Catálogo", "Nosotros", "Contacto"};
        for (String t : linkTexts) {
            Label link = new Label(t);
            link.setFont(Font.font("SF Pro Display", FontWeight.NORMAL, 14));
            link.setTextFill(Color.rgb(255, 255, 255, 0.7));
            link.setCursor(javafx.scene.Cursor.HAND);
            
            link.setOnMouseEntered(e -> link.setTextFill(Color.WHITE));
            link.setOnMouseExited(e -> link.setTextFill(Color.rgb(255, 255, 255, 0.7)));
            
            links.getChildren().add(link);
        }
        
        // Separador
        Rectangle sep = new Rectangle();
        sep.setHeight(1);
        sep.setFill(Color.rgb(255, 255, 255, 0.1));
        sep.widthProperty().bind(stage.widthProperty().multiply(0.8));
        
        // Copyright
        Label copy = new Label("© 2026 AutoPremium. Todos los derechos reservados.");
        copy.setFont(Font.font("SF Pro Display", FontWeight.LIGHT, 12));
        copy.setTextFill(Color.rgb(255, 255, 255, 0.5));
        
        footer.getChildren().addAll(logo, links, sep, copy);
        
        // Responsive
        stage.widthProperty().addListener((o, old, w) -> {
            if (w.doubleValue() < 600) {
                links.setSpacing(20);
                footer.setPadding(new Insets(40, 20, 30, 20));
            } else {
                links.setSpacing(40);
                footer.setPadding(new Insets(60, 40, 40, 40));
            }
        });
        
        return footer;
    }
    
    // ==================== ANIMATIONS ====================
    private void playEntranceAnimations(StackPane header, VBox content) {
        // Header slide down
        header.setOpacity(0);
        header.setTranslateY(-40);
        
        Timeline headerAnim = new Timeline(
            new KeyFrame(Duration.ZERO,
                new KeyValue(header.opacityProperty(), 0),
                new KeyValue(header.translateYProperty(), -40)),
            new KeyFrame(Duration.millis(700),
                new KeyValue(header.opacityProperty(), 1, Interpolator.EASE_OUT),
                new KeyValue(header.translateYProperty(), 0, Interpolator.EASE_OUT))
        );
        headerAnim.setDelay(Duration.millis(300));
        headerAnim.play();
        
        // Content fade in
        int delay = 150;
        for (javafx.scene.Node node : content.getChildren()) {
            node.setOpacity(0);
            node.setTranslateY(40);
            
            Timeline nodeAnim = new Timeline(
                new KeyFrame(Duration.ZERO,
                    new KeyValue(node.opacityProperty(), 0),
                    new KeyValue(node.translateYProperty(), 40)),
                new KeyFrame(Duration.millis(600),
                    new KeyValue(node.opacityProperty(), 1, Interpolator.EASE_OUT),
                    new KeyValue(node.translateYProperty(), 0, Interpolator.EASE_OUT))
            );
            nodeAnim.setDelay(Duration.millis(delay));
            nodeAnim.play();
            delay += 200;
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
