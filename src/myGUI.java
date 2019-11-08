import com.company.Functions;
import com.company.MathTransform;
import com.company.PhotosInfo;

import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import com.company.Task23;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.company.Functions.Mat2BufferedImage;
import static com.company.Functions.createIcon;
import static com.company.Functions.reSizeOnlyOne;
import static com.company.Task23.*;
import static com.company.Task4.solveTask4;
import static com.company.Task5.*;
import static java.lang.Math.sqrt;
import static com.company.Task4.pathToDocument;
import static com.company.Task4.listOfIndex;
import static com.company.Task4.check;

public class myGUI extends JFrame {
    private JPanel MyPanel;
    private JTabbedPane JTable;
    private JPanel Task1;
    private JPanel Task2;
    private JButton TestButt;
    private JPanel Task4;
    private JPanel Task5;
    private JPanel Task6;
    private JButton button1;
    private JButton buttonSolveTask23;
    private JButton buttonReadImages2;
    private JButton buttonSolveTask5;
    private JLabel task5Image;
    private JButton buttonNextTask5;
    private JLabel imageTask23;
    private JLabel imageTask6;
    private JButton task6btnChange;
    private JButton button2;
    private JLabel imageTask4;
    private JButton buttonTask4Previous;
    private JButton buttonTask4Next;
    private JButton buttonTask23FirstImage;
    private JButton buttonTask23SecondImage;
    private JButton buttonTask23FinalImage;
    private JButton button3;
    private JLabel task6Wheel;
    private JLabel labelValue1;
    private JLabel labelValue2;
    private JButton button4;
    private JLabel task6Color1;
    private JButton button5;
    private JButton button6;
    private JLabel task6Color2;
    private JButton інструкціяButton;
    private JButton інструкціяButton1;
    private JButton інструкціяButton3;
    private JButton інструкціяButton4;
    private JButton button7;
    private JLabel label2;
    public static JFrame mainFrame = new JFrame();
    boolean task5 = false, task6 = false;
    BufferedImage startImageTask6 = null, endImageTask6 = null,
            task23Imgage = null, task23ImageFirst = null, task23ImageSecond = null;
    int currIndexInLsImages = 0;
    public static String pathToFile = new File("").getAbsolutePath();
    Functions functions = new Functions();
    private Color color1 = new Color(255, 34, 0), color2 = new Color(255, 149, 0);

    public myGUI() {
        {
            $$$setupUI$$$();
            try {
                loadOpenCV_Lib();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            System.out.println("rofl");
            mainFrame = new JFrame("TUI");
            mainFrame.setContentPane(this.MyPanel);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.pack();
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setSize(1100, 600);
            mainFrame.setResizable(false);
            mainFrame.setVisible(true);
            System.out.println(new File("").getAbsolutePath() + " ");
            BufferedImage img = null, img2 = null, img3 = null, img4 = null, img5 = null;
            JLabel lbl  = new JLabel("<html>Побудова маршруту дрона</html>");
            JLabel lbl2 = new JLabel("<html>Найчіткіше зображення</html>");
            JLabel lbl3 = new JLabel("<html>Послідовність зображень</html>");
            JLabel lbl4 = new JLabel("<html>Знаходження відмінностей</html>");
            JLabel lbl5 = new JLabel("<html>Рекомендований полив</html>");
            ImageIcon icon, icon2, icon3, icon4, icon5;
            try {
                img = ImageIO.read(new File(pathToFile + "\\src\\first.png"));
                img2 = ImageIO.read(new File(pathToFile + "\\src\\secondthird.png"));
                img3 = ImageIO.read(new File(pathToFile + "\\src\\fourth.png"));
                img4 = ImageIO.read(new File(pathToFile + "\\src\\fifth.png"));
                img5 = ImageIO.read(new File(pathToFile + "\\src\\sixth.png"));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            icon = new ImageIcon(img);
            icon2 = new ImageIcon(img2);
            icon3 = new ImageIcon(img3);
            icon4 = new ImageIcon(img4);
            icon5 = new ImageIcon(img5);
            lbl.setIcon(icon);
            lbl2.setIcon(icon2);
            lbl3.setIcon(icon3);
            lbl4.setIcon(icon4);
            lbl5.setIcon(icon5);
            JTable.setTabComponentAt(0, lbl);
            JTable.setTabComponentAt(1, lbl2);
            JTable.setTabComponentAt(2, lbl3);
            JTable.setTabComponentAt(3, lbl4);
            JTable.setTabComponentAt(4, lbl5);
            drawColors();
            System.out.println(MathTransform.distanceFromPointToStraight(new Point3(4, 3, 0), new Point3(3, 5, 1), new Point3(2, 2, 4)));
        }
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);

            }
        });
        TestButt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        String browseTask1 = (pathToFile + "\\htdocs\\index.html").replace('\\', '/');
                        Desktop.getDesktop().browse(new URI(browseTask1));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                /*SwingUtilities.invokeLater(() -> {
                    Browser view = new Browser("file:///" + pathToFile + "/htdocs/index.html");
                    JFrame frame;
                    frame = new JFrame("Карта");
                    frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                    frame.setSize(1200, 775);
                    view.setSize(1200, 775);
                    frame.add(view);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    mainFrame.setVisible(false);
                    frame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            super.windowClosing(e);
                            mainFrame.setVisible(true);
                        }
                    });
                });*/
            }
        });
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (startImageTask6 != null && color1 != null && color2 != null) {
                    Mat src = null;
                    try {
                        src = BufferedImage2Mat(startImageTask6);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    src = Functions.reSizeOnlyOne(src);
                    try {
                        startImageTask6 = Mat2BufferedImage(src);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    Mat hsv = new Mat(src.cols(), src.rows(), 3);
                    List<Mat> splitedHsv = new ArrayList<>();
                    Imgproc.cvtColor(src, hsv, Imgproc.COLOR_BGR2HSV);
                    Core.split(hsv, splitedHsv);
                    float[] hsv1 = null, hsv2 = null;
                    hsv1 = Color.RGBtoHSB(color1.getRed(), color1.getGreen(), color1.getBlue(), null);
                    hsv2 = Color.RGBtoHSB(color2.getRed(), color2.getGreen(), color2.getBlue(), null);
                    //System.out.println(hsv1[0] + " " + hsv2[0]);
                    int HUE_MIN = (int) Math.min(hsv1[0] * 180, hsv2[0] * 180);
                    int HUE_MAX = (int) Math.max(hsv1[0] * 180, hsv2[0] * 180);
                    final int SATURATION_MIN = 40;
                    for (int y = 0; y < hsv.cols(); y++) {
                        for (int x = 0; x < hsv.rows(); x++) {
                            int H = (int) splitedHsv.get(0).get(x, y)[0];
                            int S = (int) splitedHsv.get(1).get(x, y)[0];
                            if (H >= HUE_MIN && H <= HUE_MAX && S >= SATURATION_MIN) {
                                double a[] = {(double) (H - HUE_MIN) / (HUE_MAX - HUE_MIN) * 255, (double) (H - HUE_MIN) / (HUE_MAX - HUE_MIN) * 100, 0};
                                src.put(x, y, a);
                            }
                        }
                    }
                    try {
                        endImageTask6 = Mat2BufferedImage(src);
                        imageTask6.setIcon(new ImageIcon(endImageTask6));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    task6btnChange.setText("Стартове зображення");
                    task6 = false;
                    task6btnChange.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Не коректні вхідні данні"},
                            "Помилка",
                            JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Ви маєте вибрати одне зображення"},
                            "Вхідні дані",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        buttonSolveTask23.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    readImages();

                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                if (Task23.isImageSet) {
                    try {
                        task23ImageFirst = Mat2BufferedImage(reSizeOnlyOne(Task23.img));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    try {
                        task23ImageSecond = Mat2BufferedImage(reSizeOnlyOne(Task23.img2));
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    findTransformMatrix();
                    if (diffFound) {
                        setValue();
                        try {
                            task23Imgage = Mat2BufferedImage(reSizeOnlyOne(solve()));
                            imageTask23.setIcon(new ImageIcon(task23Imgage));
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        buttonTask23FirstImage.setEnabled(true);
                        buttonTask23SecondImage.setEnabled(true);
                        buttonTask23FinalImage.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(myGUI.this,
                                new String[]{"Не вдалося знайти спільні точки"},
                                "Відповідь",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Не коректні вхідні данні"},
                            "Помилка",
                            JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Ви маєте вибрати два зображення однакового розміру"},
                            "Вхідні дані",
                            JOptionPane.INFORMATION_MESSAGE);
                    buttonTask23FirstImage.setEnabled(false);
                    buttonTask23SecondImage.setEnabled(false);
                    buttonTask23FinalImage.setEnabled(false);
                }
            }
        });
        buttonReadImages2.addKeyListener(new KeyAdapter() {
        });
        buttonReadImages2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    readImages2();
                    task5 = false;
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if (imageIsSet) {
                    BufferedImage currim = null;
                    try {
                        currim = Mat2BufferedImage(mat1);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    buttonNextTask5.setEnabled(true);
                    buttonSolveTask5.setEnabled(true);
                    task5Image.setIcon(new ImageIcon((currim)));
                } else {
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Не коректні вхідні данні"},
                            "Помилка",
                            JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Ви маєте вибрати два зображення"},
                            "Вхідні дані",
                            JOptionPane.INFORMATION_MESSAGE);
                    buttonNextTask5.setEnabled(false);
                    buttonSolveTask5.setEnabled(false);
                }
            }
        });
        buttonSolveTask5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (imageIsSet) {
                    solvetask5();
                    BufferedImage currim = null;
                    try {
                        if (!task5)
                            currim = Mat2BufferedImage(mat1);
                        else currim = Mat2BufferedImage(mat2);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    task5Image.setIcon(new ImageIcon(currim));
                }

            }
        });
        buttonNextTask5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (imageIsSet) {
                    if (task5) {
                        task5 = false;
                        buttonNextTask5.setText("Друге зображення");
                        BufferedImage currim = null;
                        try {
                            currim = Mat2BufferedImage(mat1);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        task5Image.setIcon(new ImageIcon(currim));

                    } else {
                        task5 = true;
                        buttonNextTask5.setText("Перше зображення");
                        BufferedImage currim = null;
                        try {
                            currim = Mat2BufferedImage(mat2);
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        task5Image.setIcon(new ImageIcon(currim));
                    }
                }
            }
        });
        task6btnChange.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (!task6) {
                    imageTask6.setIcon(new ImageIcon(startImageTask6));
                    task6btnChange.setText("Фінальне зображення");
                    task6 = true;
                } else {
                    task6 = false;
                    imageTask6.setIcon(new ImageIcon(endImageTask6));
                    task6btnChange.setText("Стартове зображення");
                }
            }
        });
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                boolean verify = false;
                PhotosInfo.clearPhotos();
                JFileChooser fileopen = new JFileChooser();
                int ret;
                List<String> lines;
                ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    try {
                        String s = file.getPath();
                        int index = s.length() - 1;

                        while (s.charAt(index) != pathToFile.charAt(2))
                            index--;
                        for (int i = 0; i <= index; i++)
                            pathToDocument += s.charAt(i);

                        System.out.println(pathToDocument);
                        lines = Files.readAllLines(Paths.get(file.getPath()), Charset.defaultCharset());
                        System.out.println(lines.size() + " ");
                        functions.readInfo(lines);
                    } catch (IOException a) {
                        verify = true;
                    }

                }
                if (!verify) {

                    try {
                        //listOfIndex = new ArrayList<>();
                        if (check) {
                            listOfIndex.clear();
                        }
                        solveTask4();
                        try {
                            BufferedImage img = ImageIO.read(new File(pathToDocument + "DronePhotos\\" + (listOfIndex.get(0) + 1) + ".JPG"));
                            img = Functions.Mat2BufferedImage(Functions.reSizeOnlyOne(Functions.BufferedImage2Mat(img)));
                            imageTask4.setIcon(new ImageIcon(img));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        System.out.println(listOfIndex.size());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    button3.setEnabled(true);
                    buttonTask4Previous.setEnabled(true);
                    buttonTask4Next.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Не коректні вхідні данні"},
                            "Помилка",
                            JOptionPane.ERROR_MESSAGE);
                    JOptionPane.showMessageDialog(myGUI.this,
                            new String[]{"Ви маєте вибрати текстовий файл з данними",},
                            "Вхідні дані",
                            JOptionPane.INFORMATION_MESSAGE);
                    button3.setEnabled(false);
                    buttonTask4Previous.setEnabled(false);
                    buttonTask4Next.setEnabled(false);
                }
            }
        });
        buttonTask4Next.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                currIndexInLsImages--;
                if (currIndexInLsImages <= 0) buttonTask4Previous.setEnabled(false);
                buttonTask4Next.setEnabled(true);
                if (currIndexInLsImages >= 0 && currIndexInLsImages < listOfIndex.size()) {
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new File(pathToDocument + "DronePhotos\\" + (listOfIndex.get(currIndexInLsImages) + 1) + ".JPG"));
                        img = Functions.Mat2BufferedImage(Functions.reSizeOnlyOne(Functions.BufferedImage2Mat(img)));
                        imageTask4.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                if (currIndexInLsImages <= 0) {
                    currIndexInLsImages = 0;
                    buttonTask4Previous.setEnabled(false);
                }
            }
        });
        buttonTask4Previous.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                currIndexInLsImages++;
                if (currIndexInLsImages + 1 == listOfIndex.size()) buttonTask4Next.setEnabled(false);
                buttonTask4Previous.setEnabled(true);
                if (currIndexInLsImages >= 0 && currIndexInLsImages < listOfIndex.size()) {
                    try {
                        BufferedImage img = ImageIO.read(new File(pathToDocument + "DronePhotos\\" + (listOfIndex.get(currIndexInLsImages) + 1) + ".JPG"));
                        img = Functions.Mat2BufferedImage(Functions.reSizeOnlyOne(Functions.BufferedImage2Mat(img)));
                        imageTask4.setIcon(new ImageIcon(img));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                if (currIndexInLsImages >= listOfIndex.size()) {
                    currIndexInLsImages = listOfIndex.size() - 1;
                    buttonTask4Next.setEnabled(false);
                }

            }
        });
        buttonTask23FirstImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                buttonTask23FirstImage.setEnabled(false);
                buttonTask23SecondImage.setEnabled(true);
                buttonTask23FinalImage.setEnabled(true);
                imageTask23.setIcon(new ImageIcon(task23ImageFirst));
            }
        });
        buttonTask23SecondImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                buttonTask23FirstImage.setEnabled(true);
                buttonTask23SecondImage.setEnabled(false);
                buttonTask23FinalImage.setEnabled(true);
                imageTask23.setIcon(new ImageIcon(task23ImageSecond));
            }
        });
        buttonTask23FinalImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                buttonTask23FirstImage.setEnabled(true);
                buttonTask23SecondImage.setEnabled(true);
                buttonTask23FinalImage.setEnabled(false);
                imageTask23.setIcon(new ImageIcon(task23Imgage));
            }
        });
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        String browseTask4 = (pathToFile + "\\htdocs\\map.html").replace('\\', '/');
                        Desktop.getDesktop().browse(new URI(browseTask4));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                /*Browser view = new Browser("file:///" + pathToFile + "/src/com/company/map.html");
                JFrame frame;
                frame = new JFrame("Карта");
                frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                frame.setSize(1200, 775);
                view.setSize(1200, 775);
                frame.add(view);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);*/
            }
        });
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JFileChooser fileopen = new JFileChooser();
                int ret = fileopen.showDialog(null, "Открыть файл");
                if (ret == JFileChooser.APPROVE_OPTION) {
                    File file = fileopen.getSelectedFile();
                    String path1 = file.getPath();
                    try {
                        startImageTask6 = ImageIO.read(new File(path1));
                    } catch (IOException a) {

                    }
                }
            }
        });
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Color newColor = JColorChooser.showDialog(null, "Choose a color", color1);
                color1 = newColor;
                task6Color1.setIcon(createIcon(color1, 16, 16));
            }
        });
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Color newColor = JColorChooser.showDialog(null, "Choose a color", color2);
                color2 = newColor;
                task6Color2.setIcon(createIcon(color2, 16, 16));
            }
        });

    }

    //Mat color1, color2, hsvColor1, hsvColor2;
    //BufferedImage col1 = null;
    //BufferedImage col2 = null;
    public void drawColors() {
        task6Color1.setIcon(createIcon(color1, 16, 16));
        task6Color2.setIcon(createIcon(color2, 16, 16));
    }


    public static void loadOpenCV_Lib() throws Exception {
        /*String model = System.getProperty("sun.arch.data.model");
        String libraryPath = "D:\\myProjects\\TUI\\opencv\\build\\java\\x86\\";
        if (model.equals("64")) {
            libraryPath = "D:\\myProjects\\TUI\\opencv\\build\\java\\x64\\";
        }
        System.setProperty("java.library.path", libraryPath);
        Field sysPath = ClassLoader.class.getDeclaredField("sys_paths");
        sysPath.setAccessible(true);
        sysPath.set(null, null);*/
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }


    public static void main(String[] args) throws Exception {

    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        //   $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        MyPanel = new JPanel();
        MyPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        MyPanel.setBackground(new Color(-986896));
        MyPanel.setMinimumSize(new Dimension(818, 800));
        MyPanel.setPreferredSize(new Dimension(818, 800));
        JTable = new JTabbedPane();
        JTable.setBackground(new Color(-986896));
        JTable.setTabPlacement(2);
        MyPanel.add(JTable, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        Task1 = new JPanel();
        Task1.setLayout(new GridBagLayout());
        Task1.setBackground(new Color(-2953488));
        Task1.setMinimumSize(new Dimension(814, 800));
        Task1.setPreferredSize(new Dimension(814, 800));
        JTable.addTab("Завдання 1", Task1);
        TestButt = new JButton();
        TestButt.setAlignmentY(0.0f);
        TestButt.setText("Запустити");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        Task1.add(TestButt, gbc);
        final JLabel label1 = new JLabel();
        label1.setAlignmentY(0.0f);
        label1.setIcon(new ImageIcon(getClass().getResource("/dron3.jpg")));
        label1.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.NORTH;
        Task1.add(label1, gbc);
        Task2 = new JPanel();
        Task2.setLayout(new GridBagLayout());
        Task2.setAlignmentX(0.0f);
        Task2.setAlignmentY(0.0f);
        Task2.setBackground(new Color(-2953488));
        JTable.addTab("Завдання 2,3", Task2);
        imageTask23 = new JLabel();
        imageTask23.setAlignmentY(0.0f);
        imageTask23.setIcon(new ImageIcon(getClass().getResource("/dron.jpg")));
        imageTask23.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.weighty = 0.01;
        Task2.add(imageTask23, gbc);
        buttonTask23FirstImage = new JButton();
        buttonTask23FirstImage.setAlignmentY(0.0f);
        buttonTask23FirstImage.setBackground(new Color(-1987561));
        buttonTask23FirstImage.setEnabled(false);
        buttonTask23FirstImage.setText("Перше зображення");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.NORTH;
        Task2.add(buttonTask23FirstImage, gbc);
        buttonTask23FinalImage = new JButton();
        buttonTask23FinalImage.setAlignmentY(0.1f);
        buttonTask23FinalImage.setBackground(new Color(-1987561));
        buttonTask23FinalImage.setEnabled(false);
        buttonTask23FinalImage.setText("Фінальне зображення");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.NORTH;
        Task2.add(buttonTask23FinalImage, gbc);
        buttonTask23SecondImage = new JButton();
        buttonTask23SecondImage.setAlignmentY(0.0f);
        buttonTask23SecondImage.setBackground(new Color(-1987561));
        buttonTask23SecondImage.setEnabled(false);
        buttonTask23SecondImage.setText("Друге зображення");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.NORTH;
        Task2.add(buttonTask23SecondImage, gbc);
        buttonSolveTask23 = new JButton();
        buttonSolveTask23.setAlignmentY(0.1f);
        buttonSolveTask23.setBackground(new Color(-7741153));
        buttonSolveTask23.setText("Вибрати зображення");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.01;
        Task2.add(buttonSolveTask23, gbc);
        інструкціяButton3 = new JButton();
        інструкціяButton3.setText("Інструкція");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.001;
        Task2.add(інструкціяButton3, gbc);
        Task4 = new JPanel();
        Task4.setLayout(new GridBagLayout());
        Task4.setAlignmentX(0.0f);
        Task4.setAlignmentY(0.0f);
        Task4.setBackground(new Color(-2953488));
        JTable.addTab("Завдання 4", Task4);
        imageTask4 = new JLabel();
        imageTask4.setAlignmentY(0.0f);
        imageTask4.setIcon(new ImageIcon(getClass().getResource("/dron.jpg")));
        imageTask4.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.weighty = 1.0E-4;
        gbc.anchor = GridBagConstraints.NORTH;
        Task4.add(imageTask4, gbc);
        button2 = new JButton();
        button2.setAlignmentY(0.0f);
        button2.setBackground(new Color(-7741153));
        button2.setText("Вибрати файл");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.001;
        gbc.insets = new Insets(10, 0, 10, 0);
        Task4.add(button2, gbc);
        button3 = new JButton();
        button3.setAlignmentY(0.0f);
        button3.setBackground(new Color(-1987561));
        button3.setEnabled(false);
        button3.setText("Виконати");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.001;
        Task4.add(button3, gbc);
        buttonTask4Previous = new JButton();
        buttonTask4Previous.setAlignmentY(0.0f);
        buttonTask4Previous.setBackground(new Color(-1987561));
        buttonTask4Previous.setEnabled(false);
        buttonTask4Previous.setText("Наступне зображення");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 0, 0, 0);
        Task4.add(buttonTask4Previous, gbc);
        buttonTask4Next = new JButton();
        buttonTask4Next.setAlignmentY(0.0f);
        buttonTask4Next.setBackground(new Color(-1987561));
        buttonTask4Next.setEnabled(false);
        buttonTask4Next.setText("Попереднє зображення");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 0, 0, 0);
        Task4.add(buttonTask4Next, gbc);
        інструкціяButton4 = new JButton();
        інструкціяButton4.setText("Інструкція");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        Task4.add(інструкціяButton4, gbc);
        Task5 = new JPanel();
        Task5.setLayout(new GridBagLayout());
        Task5.setBackground(new Color(-2953488));
        JTable.addTab("Завдання 5", Task5);
        task5Image = new JLabel();
        task5Image.setIcon(new ImageIcon(getClass().getResource("/dron.jpg")));
        task5Image.setText("");
        task5Image.setVerticalAlignment(0);
        task5Image.setVerticalTextPosition(0);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.NORTH;
        Task5.add(task5Image, gbc);
        buttonNextTask5 = new JButton();
        buttonNextTask5.setBackground(new Color(-1987561));
        buttonNextTask5.setEnabled(false);
        buttonNextTask5.setText("Друге зображення");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.001;
        Task5.add(buttonNextTask5, gbc);
        buttonReadImages2 = new JButton();
        buttonReadImages2.setBackground(new Color(-7741153));
        buttonReadImages2.setText("Вибрати зображення");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.001;
        gbc.insets = new Insets(10, 0, 10, 0);
        Task5.add(buttonReadImages2, gbc);
        buttonSolveTask5 = new JButton();
        buttonSolveTask5.setBackground(new Color(-1987561));
        buttonSolveTask5.setEnabled(false);
        buttonSolveTask5.setText("Виконати");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.001;
        Task5.add(buttonSolveTask5, gbc);
        інструкціяButton1 = new JButton();
        інструкціяButton1.setText("Інструкція");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.001;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(0, 0, 250, 0);
        Task5.add(інструкціяButton1, gbc);
        Task6 = new JPanel();
        Task6.setLayout(new GridBagLayout());
        Task6.setBackground(new Color(-2953488));
        JTable.addTab("Завдання 6", Task6);
        task6btnChange = new JButton();
        task6btnChange.setBackground(new Color(-1987561));
        task6btnChange.setEnabled(false);
        task6btnChange.setText(" Стартове зображення");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.001;
        Task6.add(task6btnChange, gbc);
        imageTask6 = new JLabel();
        imageTask6.setIcon(new ImageIcon(getClass().getResource("/dron.jpg")));
        imageTask6.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.NORTH;
        Task6.add(imageTask6, gbc);
        button4 = new JButton();
        button4.setBackground(new Color(-7741153));
        button4.setText("Вибрати зображення");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);
        Task6.add(button4, gbc);
        button1 = new JButton();
        button1.setBackground(new Color(-7741153));
        button1.setText("Обробити зображення");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.001;
        gbc.insets = new Insets(10, 0, 0, 0);
        Task6.add(button1, gbc);
        task6Wheel = new JLabel();
        task6Wheel.setIcon(new ImageIcon(getClass().getResource("/color-wheel.jpg")));
        task6Wheel.setText("");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        Task6.add(task6Wheel, gbc);
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.setBackground(new Color(-2953488));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(50, 0, 0, 0);
        Task6.add(panel1, gbc);
        labelValue1 = new JLabel();
        labelValue1.setText("Перший колір");
        panel1.add(labelValue1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        task6Color1 = new JLabel();
        task6Color1.setText("");
        panel1.add(task6Color1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        button5 = new JButton();
        button5.setBackground(new Color(-7741153));
        button5.setText("Виберіть перший колір");
        panel1.add(button5, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        button6 = new JButton();
        button6.setBackground(new Color(-7741153));
        button6.setText("Виберіть другий колір");
        panel1.add(button6, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        task6Color2 = new JLabel();
        task6Color2.setText("");
        panel1.add(task6Color2, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        labelValue2 = new JLabel();
        labelValue2.setText("Другий колір");
        panel1.add(labelValue2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        інструкціяButton = new JButton();
        інструкціяButton.setText("Інструкція");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 1.0;
        gbc.weighty = 0.001;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(0, 0, 300, 0);
        Task6.add(інструкціяButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return MyPanel;
    }

}


