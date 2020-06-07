package es.studium.Ayuda;

import java.io.IOException;

public class Ayuda
{
	public Ayuda()
	{
		try
		{

			Runtime.getRuntime().exec("hh.exe ayudaAjedrez.chm");
		} catch (IOException error)
		{

			error.printStackTrace();
		}

	}
}
