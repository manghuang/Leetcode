package parse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 解析class文件
 */
public class ParseClassFile {
    /**
     * class文件的二进制码
     */
    private final List<Integer> bytes;
    /**
     * 暂存解析的结果
     */
    private final StringBuilder stringBuilder;


    /**
     * 构造函数
     */
    public ParseClassFile() {
        this.bytes = new ArrayList<>();
        stringBuilder = new StringBuilder();
    }



    /**
     * 加载文件
     *
     * @param str 文件路径
     */
    private void loadFile(String str) {
        File file = new File(str);
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            try {
                while (dataInputStream.available() != 0) {
                    int val = Byte.toUnsignedInt(dataInputStream.readByte());
                    bytes.add(val);
//                    System.out.println(Integer.toHexString(val));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("文件不存在");
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        System.out.println(bytes);
    }

    /**
     * 解析class文件
     *
     * @param path   路径
     * @param src    源文件名称
     * @param target 目标文件名称
     */
    public void parse(String path, String src, String target) {
        stringBuilder.append("文件原路径：").append(path).append(src);
        this.loadFile(path + src);
        stringBuilder.append("\n").append("魔数：").
                append(toHex(bytes.get(0))).append(toHex(bytes.get(1))).
                append(" ").append(toHex(bytes.get(2))).append(toHex(bytes.get(3)));
        stringBuilder.append("\n").append("副版本号：").append(toHex(bytes.get(4))).append(toHex(bytes.get(5)));
        stringBuilder.append("\n").append("主版本号：").append(toHex(bytes.get(6))).append(toHex(bytes.get(7)));
        int index = this.parseCpInfo();
        stringBuilder.append("\n").append("访问标志位：").append(toHex(bytes.get(index++))).append(toHex(bytes.get(index++)));
        stringBuilder.append("\n").append("当前类索引：").append(toHex(bytes.get(index++))).append(toHex(bytes.get(index++)));
        stringBuilder.append("\n").append("父类索引：").append(toHex(bytes.get(index++))).append(toHex(bytes.get(index++)));
        index = parseInterface(index);
        index = parseFiledInfo(index);
        index = parseMethodInfo(index);
        index = parseAttributeInfo(index);
        if (index != bytes.size()) {
            throw new RuntimeException("未完全解析");
        }
        stringBuilder.append("\n").append("文件目标路径：").append(path).append(target);
        this.storeFile(path + target);
    }

    /**
     * 解析常量池
     *
     * @return 结束后的下一个index
     */
    private int parseCpInfo() {

        stringBuilder.append("\n").append("常量池计数器：").append(toHex(bytes.get(8))).append(toHex(bytes.get(9)));
        int count = bytes.get(8) * 256 + bytes.get(9) - 1;
        stringBuilder.append("\n").append("常量池：");
//        System.out.println(count);
        int index = 10;
        while (count > 0) {
            int tag = bytes.get(index);
            CP_INFO cp_info;
            switch (tag) {
                case 1:
                    cp_info = CP_INFO.CONSTANT_utf8_info;
                    break;
                case 3:
                    cp_info = CP_INFO.CONSTANT_Integer_info;
                    break;
                case 4:
                    cp_info = CP_INFO.CONSTANT_Float_info;
                    break;
                case 5:
                    cp_info = CP_INFO.CONSTANT_Long_info;
                    break;
                case 6:
                    cp_info = CP_INFO.CONSTANT_Double_info;
                    break;
                case 7:
                    cp_info = CP_INFO.CONSTANT_Class_info;
                    break;
                case 8:
                    cp_info = CP_INFO.CONSTANT_String_info;
                    break;
                case 9:
                    cp_info = CP_INFO.CONSTANT_Fieldref_info;
                    break;
                case 10:
                    cp_info = CP_INFO.CONSTANT_Methodref_info;
                    break;
                case 11:
                    cp_info = CP_INFO.CONSTANT_InterfaceMethodref_info;
                    break;
                case 12:
                    cp_info = CP_INFO.CONSTANT_NameAndType_info;
                    break;
                case 15:
                    cp_info = CP_INFO.CONSTANT_MethodHandle_info;
                    break;
                case 16:
                    cp_info = CP_INFO.CONSTANT_MethodType_info;
                    break;
                case 18:
                    cp_info = CP_INFO.CONSTANT_InvokeDynamic_info;
                    break;
                default:
                    throw new RuntimeException("CP_INFO的tag不合法");
            }
            StringBuilder temp = new StringBuilder();
            if (cp_info == CP_INFO.CONSTANT_utf8_info) {
                temp.append("\n")
                        .append("  ")
                        .append(toHex(bytes.get(index++)))
                        .append(" ")
                        .append(toHex(bytes.get(index)))
                        .append(toHex(bytes.get(index + 1)))
                        .append(" ");
                int length = bytes.get(index++) * 256 + bytes.get(index++);
                while (length > 0) {
                    temp.append(toHex(bytes.get(index++)));
                    length--;
                }
            } else {
                temp.append("\n")
                        .append("  ")
                        .append(toHex(bytes.get(index++)))
                        .append(" ");
                int length = cp_info.getLength() - 1;
                while (length > 0) {
                    temp.append(toHex(bytes.get(index++)));
                    length--;
                }
            }
            stringBuilder.append(temp);
            count--;
        }
        return index;
    }

    /**
     * 解析接口索引
     *
     * @param index 指向第一个字节的index
     * @return 结束后的下一个index
     */
    private int parseInterface(int index) {
        stringBuilder.append("\n").append("接口索引计数器：").append(toHex(bytes.get(index))).append(toHex(bytes.get(index + 1)));
        int count = bytes.get(index++) * 256 + bytes.get(index++);
        stringBuilder.append("\n").append("接口索引集合：");
//        System.out.println(stringBuilder.toString());
        while (count > 0) {
            stringBuilder.append("\n").append("  ").append(toHex(bytes.get(index++))).append(toHex(bytes.get(index++)));
            count--;
        }
        return index;
    }

    /**
     * 解析字段表
     *
     * @param index 指向第一个字节的index
     * @return 结束后的下一个index
     */
    private int parseFiledInfo(int index) {
        stringBuilder.append("\n").append("字段表计数器：").append(toHex(bytes.get(index))).append(toHex(bytes.get(index + 1)));
        int filedsCount = bytes.get(index++) * 256 + bytes.get(index++);
        stringBuilder.append("\n").append("字段表集合：");

        while (filedsCount > 0) {
            stringBuilder.append("\n").append("  ").append(toHex(bytes.get(index++))).append(toHex(bytes.get(index++)));
            stringBuilder.append("  ").append(toHex(bytes.get(index++))).append(toHex(bytes.get(index++)));
            stringBuilder.append("  ").append(toHex(bytes.get(index++))).append(toHex(bytes.get(index++)));
            stringBuilder.append("  ").append(toHex(bytes.get(index))).append(toHex(bytes.get(index + 1)));
            int attributesCount = bytes.get(index++) * 256 + bytes.get(index++);
            while (attributesCount > 0) {
                stringBuilder.append("  ").append(toHex(bytes.get(index++))).append(toHex(bytes.get(index++)));
                stringBuilder.append("  ").
                        append(toHex(bytes.get(index))).
                        append(toHex(bytes.get(index + 1))).
                        append(toHex(bytes.get(index + 2))).
                        append(toHex(bytes.get(index + 3))).append("  ");
                int length = (int) (bytes.get(index++) * Math.pow(256, 3) + bytes.get(index++) * Math.pow(256, 2) +
                        bytes.get(index++) * 256 + bytes.get(index++));
                while (length > 0) {
                    stringBuilder.append(toHex(bytes.get(index++)));
                    length--;
                }
                attributesCount--;
            }
            filedsCount--;
        }
        return index;
    }

    /**
     * 解析方法表
     *
     * @param index 指向第一个字节的index
     * @return 结束后的下一个index
     */
    private int parseMethodInfo(int index) {
        stringBuilder.append("\n").append("方法表计数器：").append(toHex(bytes.get(index))).append(toHex(bytes.get(index + 1)));
        int methodsCount = bytes.get(index++) * 256 + bytes.get(index++);
        stringBuilder.append("\n").append("方法表集合：");

        while (methodsCount > 0) {
            stringBuilder.append("\n").append("  ").append(toHex(bytes.get(index++))).append(toHex(bytes.get(index++)));
            stringBuilder.append("  ").append(toHex(bytes.get(index++))).append(toHex(bytes.get(index++)));
            stringBuilder.append("  ").append(toHex(bytes.get(index++))).append(toHex(bytes.get(index++)));
            stringBuilder.append("  ").append(toHex(bytes.get(index))).append(toHex(bytes.get(index + 1)));
            int attributesCount = bytes.get(index++) * 256 + bytes.get(index++);
            while (attributesCount > 0) {
                stringBuilder.append("  ").append(toHex(bytes.get(index++))).append(toHex(bytes.get(index++)));
                stringBuilder.append("  ").
                        append(toHex(bytes.get(index))).
                        append(toHex(bytes.get(index + 1))).
                        append(toHex(bytes.get(index + 2))).
                        append(toHex(bytes.get(index + 3))).append("  ");
                int length = (int) (bytes.get(index++) * Math.pow(256, 3) + bytes.get(index++) * Math.pow(256, 2) +
                        bytes.get(index++) * 256 + bytes.get(index++));
                while (length > 0) {
                    stringBuilder.append(toHex(bytes.get(index++)));
                    length--;
                }
                attributesCount--;
            }
            methodsCount--;
        }
        return index;
    }

    /**
     * 解析属性表
     *
     * @param index 指向第一个字节的index
     * @return 结束后的下一个index
     */
    private int parseAttributeInfo(int index) {
        stringBuilder.append("\n").append("属性计数器：").append(toHex(bytes.get(index))).append(toHex(bytes.get(index + 1)));
        int attributesCount = bytes.get(index++) * 256 + bytes.get(index++);
        stringBuilder.append("\n").append("属性表集合：");
        while (attributesCount > 0) {
            stringBuilder.append("\n").append("  ").append(toHex(bytes.get(index++))).append(toHex(bytes.get(index++)));
            stringBuilder.append("  ").
                    append(toHex(bytes.get(index))).
                    append(toHex(bytes.get(index + 1))).
                    append(toHex(bytes.get(index + 2))).
                    append(toHex(bytes.get(index + 3))).append("  ");
            int length = (int) (bytes.get(index++) * Math.pow(256, 3) + bytes.get(index++) * Math.pow(256, 2) +
                    bytes.get(index++) * 256 + bytes.get(index++));
            while (length > 0) {
                stringBuilder.append(toHex(bytes.get(index++)));
                length--;
            }
            attributesCount--;
        }
        return index;
    }

    /**
     * 输出结果文件
     */
    private void storeFile(String src) {
        System.out.println(stringBuilder.toString());
        File file = new File(src);
//        if(file.exists()){
//            System.out.println("文件存在");
//        }else {
//            System.out.println("文件不存在");
//        }
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            printWriter.print(stringBuilder.toString());
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(file.getParent());
        System.out.println("结果文件路径：" + src);
    }

    /**
     * 将int值转换为十六进制表示
     *
     * @param val int类型的值
     * @return 十六进制的字符串
     */
    private String toHex(int val) {
        if (val < 16) {
            return "0" + Integer.toHexString(val);
        }
        return Integer.toHexString(val);
    }

    /**
     * 存放常量池常量的类型和结构
     */
    private static enum CP_INFO {
        CONSTANT_utf8_info(1, false, -1),
        CONSTANT_Integer_info(3, true, 5),
        CONSTANT_Float_info(4, true, 5),
        CONSTANT_Long_info(5, true, 9),
        CONSTANT_Double_info(6, true, 9),
        CONSTANT_Class_info(7, true, 3),
        CONSTANT_String_info(8, true, 3),
        CONSTANT_Fieldref_info(9, true, 5),
        CONSTANT_Methodref_info(10, true, 5),
        CONSTANT_InterfaceMethodref_info(11, true, 5),
        CONSTANT_NameAndType_info(12, true, 5),
        CONSTANT_MethodHandle_info(15, true, 4),
        CONSTANT_MethodType_info(16, true, 3),
        CONSTANT_InvokeDynamic_info(18, true, 5);

        private  final int tag;
        private final boolean isSolid;
        private final int length;

        private CP_INFO(int tag, boolean isSolid, int length) {
            this.tag = tag;
            this.isSolid = isSolid;
            this.length = length;
        }

        public int getTag() {
            return tag;
        }

        public boolean isSolid() {
            return isSolid;
        }

        public int getLength() {
            return length;
        }

    }
}
