#include <stdio.h>
#include <stdbool.h>

typedef struct Dead
{
    int removido;
} Dead;

bool is_cousin(int element_param)
{
    if (element_param == 2)
    {
        return true;
    }
    else if (element_param == 3)
    {
        return true;
    }
    else if (element_param == 5)
    {
        return true;
    }
    else if (element_param == 7)
    {
        return true;
    }
    else
    {
        if (element_param % 2 != 0 && element_param % 3 != 0 && element_param % 5 != 0 && element_param % 7 != 0)
        {
            return true;
        }
    }

    return false;
}

int main(void)
{
    int input = 0;
    while (scanf("%d", &input) != 0)
    {
        int *people = (int*)malloc(input*sizeof(int));

        size_t i;
        for (i = 0; i < input; i++)
        {
            people[i] = i+1;
        }

        int pos = 0;
        int prime = 0;
        while (i > 1)
        {
            for (size_t i = prime+1; i < 32520; i++)
            {
                if (is_cousin(i))
                {
                    prime = i;
                    i = 32520;
                }
            }
            for (size_t i = pos; i < prime; i++)
            {
                pos++;
                if (pos > input)
                {
                    pos = 0;
                }
            }
            
            
        }
        
        
    }
    

    return 0;
}