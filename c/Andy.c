#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// struct
typedef struct Palavra
{
    char palavra[201];
} Palavra;

// procurar string
bool searchStr(char *str, Palavra *dicionario, int size)
{
    int i = 0;

    for (i = 0; i < size; i++)
    {
        if (strcmp(dicionario[i].palavra, str) == 0)
        {
            return true;
        }
    }
    return false;
}

void swap(Palavra *dicionario, int i, int j)
{
    Palavra tmp;
    tmp = dicionario[i];
    dicionario[i] = dicionario[j];
    dicionario[j] = tmp;
}

void quicksort(Palavra *dicionario, int start, int end)
{
    int i = start, j = end;
    Palavra pivo;
    pivo = dicionario[(i + j) / 2];
    while (i <= j)
    {
        while (strcmp(dicionario[i].palavra, pivo.palavra) < 0)
        {
            i++;
        }
        while (strcmp(dicionario[j].palavra, pivo.palavra) > 0)
        {
            j--;
        }
        if (i <= j)
        {
            swap(dicionario, i, j);
            i++;
            j--;
        }
    }
    if (start < j)
    {
        quicksort(dicionario, start, j);
    }
    if (i < end)
    {
        quicksort(dicionario, i, end);
    }
}

int main()
{
    Palavra dicionario[5001];
    char palavraTmp[201], output[201];
    int i, j, size = 0;
    memset(dicionario, 0, sizeof(dicionario));
    while (scanf(" %[^\r\n]%*c", palavraTmp) != EOF)
    {
        // printf("start\n");
        i = j = 0;

        while (palavraTmp[i])
        {
            // transformar todas letras para minuscula
            while (isalpha(palavraTmp[i]))
            {
                output[j++] = tolower(palavraTmp[i++]);
            }
            // printf("tolower\n");
            if (palavraTmp[i] == '\0')
            {
                output[j] = '\0';

                if (!searchStr(output, dicionario, size))
                {
                    strcpy(dicionario[size++].palavra, output);
                }
                j = 0;
                memset(output, 0, sizeof(output)); // resetar variavel
                break;
            }
            // printf("adicionar ao dicionario1\n");

            output[j] = '\0'; 
            
            // printf("Encerrar output");
            while (!isalpha(palavraTmp[i])) // enquanto nao for letra, avançar
            {
                i++;
                if (palavraTmp[i] == '\0')
                {
                    break;
                }
            }

            if (!searchStr(output, dicionario, size))
            {
                strcpy(dicionario[size++].palavra, output);
            }
            j = 0;
            memset(output, 0, sizeof(output)); // resetar variavel
            // printf("adicionar ao dicionario2\n");
        }
        memset(palavraTmp, 0, sizeof(palavraTmp));
    }

    quicksort(dicionario, 0, size - 1);
    j = 0;
    // printf("quicksort\n");
    if (strcmp(dicionario[0].palavra, "\0") == 0)
    {
        j = 1;
    }
    // printf("verificar barra zero\n");
    for (; j < size; j++)
    {
        printf("%s\n", dicionario[j].palavra);
    }

    return 0;
}