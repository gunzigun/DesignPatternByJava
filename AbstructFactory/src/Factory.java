/**
 * Created by Administrator on 2019/4/11.
 */

interface PictureReader
{
    void Read();
}

class GIFPictureReader implements PictureReader
{
    @Override
    public void Read()
    {
        System.out.println("读取GIF图片");
    }
}

class JPGPictureReader implements PictureReader
{
    @Override
    public void Read()
    {
        System.out.println("读取JPG图片");
    }
}

interface PictureReaderFactory
{
    PictureReader createPictureReader();
}

class GIFPictureReaderFactory implements PictureReaderFactory
{
    @Override
    public PictureReader createPictureReader()
    {
        return new GIFPictureReader();
    }
}

class JPGPictureReaderFactory implements PictureReaderFactory
{
    @Override
    public PictureReader createPictureReader()
    {
        return new JPGPictureReader();
    }
}

public class Factory
{
    public static void main(String[] args)
    {
        // 读取GIF图片
        PictureReaderFactory oGIFPictureReaderFactory = new GIFPictureReaderFactory();
        PictureReader oGIFPictureReader = oGIFPictureReaderFactory.createPictureReader();
        oGIFPictureReader.Read();

        // 读取JPG图片
        PictureReaderFactory oJPGPictureReaderFactory = new JPGPictureReaderFactory();
        PictureReader oJPGPictureReader = oJPGPictureReaderFactory.createPictureReader();
        oJPGPictureReader.Read();
    }
}
