package poo;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.concurrent.Executors;
import com.sun.net.httpserver.*;
import java.awt.Desktop;

public class App {
    
    private static final int PORT = 5174;
    private static HttpServer server;
    private static final String WEB_ROOT = "src/main/www/dist";
    
    public static void main(String[] args) {
        try {
            System.out.println("====================================");
            System.out.println("  AutoExotic - Luxury Cars Catalog");
            System.out.println("====================================");
            System.out.println();
            
            startHttpServer();
            
            // Esperar un momento para que el servidor esté completamente listo
            Thread.sleep(1000);
            
            // Abrir en el navegador predeterminado
            String url = "http://localhost:" + PORT;
            System.out.println("Abriendo " + url + " en tu navegador...");
            openBrowser(url);
            
            System.out.println();
            System.out.println("Servidor corriendo en: " + url);
            System.out.println("Presiona Ctrl+C para detener el servidor");
            System.out.println();
            
            // Agregar shutdown hook para limpiar cuando se cierre la aplicación
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("\nCerrando servidor...");
                stopHttpServer();
            }));
            
            // Mantener el programa corriendo
            Thread.currentThread().join();
            
        } catch (Exception e) {
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
            e.printStackTrace();
            stopHttpServer();
        }
    }
    
    private static void openBrowser(String url) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                // Fallback: intentar con comandos del sistema
                String os = System.getProperty("os.name").toLowerCase();
                if (os.contains("win")) {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
                } else if (os.contains("mac")) {
                    Runtime.getRuntime().exec("open " + url);
                } else {
                    Runtime.getRuntime().exec("xdg-open " + url);
                }
            }
        } catch (Exception e) {
            System.err.println("No se pudo abrir el navegador automáticamente.");
            System.err.println("Por favor, abre manualmente: " + url);
        }
    }
    
    private static void startHttpServer() {
        try {
            server = HttpServer.create(new InetSocketAddress(PORT), 0);
            server.createContext("/", new StaticFileHandler());
            server.setExecutor(Executors.newCachedThreadPool());
            server.start();
            System.out.println("Servidor HTTP iniciado en el puerto " + PORT);
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void stopHttpServer() {
        if (server != null) {
            server.stop(0);
            System.out.println("Servidor HTTP detenido");
        }
    }
    
    static class StaticFileHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String requestPath = exchange.getRequestURI().getPath();
            if ("/".equals(requestPath)) {
                requestPath = "/index.html";
            }
            
            Path filePath = Paths.get(WEB_ROOT + requestPath).normalize();
            File file = filePath.toFile();
            if (!file.exists() || file.isDirectory()) {
                filePath = Paths.get(WEB_ROOT + "/index.html");
                file = filePath.toFile();
            }
            
            if (file.exists() && !file.isDirectory()) {
                String contentType = getContentType(filePath.toString());
                byte[] fileContent = Files.readAllBytes(filePath);
                long fileLength = fileContent.length;
                
                exchange.getResponseHeaders().set("Content-Type", contentType);
                exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
                exchange.getResponseHeaders().set("Accept-Ranges", "bytes");
                String rangeHeader = exchange.getRequestHeaders().getFirst("Range");
                
                if (rangeHeader != null && contentType.startsWith("video/")) {
                    String[] ranges = rangeHeader.replace("bytes=", "").split("-");
                    long start = Long.parseLong(ranges[0]);
                    long end = ranges.length > 1 && !ranges[1].isEmpty() ? 
                               Long.parseLong(ranges[1]) : fileLength - 1;
                    if (end >= fileLength) end = fileLength - 1;
                    long contentLength = end - start + 1;
                    exchange.getResponseHeaders().set("Content-Range", 
                        "bytes " + start + "-" + end + "/" + fileLength);
                    exchange.getResponseHeaders().set("Content-Length", String.valueOf(contentLength));
                    exchange.sendResponseHeaders(206, contentLength);
                    
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(fileContent, (int)start, (int)contentLength);
                    }
                } else {
                    exchange.sendResponseHeaders(200, fileLength);
                    try (OutputStream os = exchange.getResponseBody()) {
                        os.write(fileContent);
                    }
                }
            } else {
                String response = "404 (Not Found)\n";
                exchange.sendResponseHeaders(404, response.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            }
        }
        
        private String getContentType(String filePath) {
            if (filePath.endsWith(".html")) return "text/html; charset=UTF-8";
            if (filePath.endsWith(".css")) return "text/css; charset=UTF-8";
            if (filePath.endsWith(".js")) return "application/javascript; charset=UTF-8";
            if (filePath.endsWith(".json")) return "application/json; charset=UTF-8";
            if (filePath.endsWith(".png")) return "image/png";
            if (filePath.endsWith(".jpg") || filePath.endsWith(".jpeg")) return "image/jpeg";
            if (filePath.endsWith(".gif")) return "image/gif";
            if (filePath.endsWith(".svg")) return "image/svg+xml";
            if (filePath.endsWith(".ico")) return "image/x-icon";
            if (filePath.endsWith(".mp4")) return "video/mp4";
            if (filePath.endsWith(".webm")) return "video/webm";
            if (filePath.endsWith(".woff")) return "font/woff";
            if (filePath.endsWith(".woff2")) return "font/woff2";
            if (filePath.endsWith(".ttf")) return "font/ttf";
            return "application/octet-stream";
        }
    }
}
