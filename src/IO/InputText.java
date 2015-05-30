package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputText implements Input {

    private String linha = " ";
    private FileReader reader;
    private BufferedReader leitor;

    private int N, D;
    private int[][] matrix;

    private String elemento = "";

    @Override
    public void open(String path) {
        try {
            File arquivo = new File(path);
            reader = new FileReader(arquivo);
            leitor = new BufferedReader(reader);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InputText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void close() {
        try {
            reader.close();
            leitor.close();
        } catch (IOException ex) {
            Logger.getLogger(InputText.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void read() {
        try {
            try {
                linha += leitor.readLine() + " ";
                
                ArrayList<String> elementos = new ArrayList<>();
                
                for (int i = 0; i < linha.length() - 1; i++) {
                    if (linha.charAt(i) == ' ') {
                        for (int j = i + 1; j < linha.length() - 1; j++) {
                            if (linha.charAt(j) == ' ') {
                                break;
                            } else {
                                elemento += linha.charAt(j);
                            }
                        }
                        elementos.add(elemento);
                        elemento = "";
                    }
                }
                
                N = Integer.parseInt(elementos.get(0));
                D = Integer.parseInt(elementos.get(1));
                
                matrix = new int[N][N];
                
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        matrix[i][j] = 0;
                    }
                }
                
            } catch (IOException ex) {
                Logger.getLogger(InputText.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            elemento = "";
            
            int ID = 0;
            int contador ;
            int linh = 0;
            while (leitor.ready()) {
                
                linha = " " + leitor.readLine() + " ";
                
                contador = ID + 1;
                
                for (int i = 0; i < linha.length() - 1; i++) {
                    
                    if (linha.charAt(i) == ' ') {
                        for (int j = i + 1; j < linha.length() - 1; j++) {
                            if (linha.charAt(j) == ' ') {
                                break;
                            } else {
                                elemento += linha.charAt(j);
                            }
                        }
                        
                        matrix[linh][contador] = Integer.parseInt(elemento);
                        contador++;
                        elemento = "";
                    }
                }
                
                linh++;
                ID++;
            }
            
        } catch (IOException ex) {
            Logger.getLogger(InputText.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public int[][] getData() {
        return matrix;
    }

    @Override
    public int[] getConfig() {
        int [] config = new int[2];
        config[0] = N;
        config[1] = D;
        return config;
    }
}
