#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main(void){
    int nums;

    scanf("%d", &nums);

    while (nums != 0)
    {
        int* arr = (int*)malloc(nums*sizeof(int));

        for (size_t i = 0; i < nums; i++)
        {
            int AUX = 0;
            scanf("%d", &AUX);
            arr[i] = AUX;
        }

        bool Marcelo = true;
        bool Carlos = false;
        
        for (size_t i = 0; i < nums-1; i++)
        {
            int maior = i;
            for (size_t j = (i+1); j < nums; j++)
            {
                if (arr[maior] > arr[j])
                {
                    maior = j;
                }
            }
            if (i != maior)
            {
                // swap
                int tmp = arr[i];
                arr[i] = arr[maior];
                arr[maior] = tmp;
                // trocar
                Marcelo = !Marcelo;
                Carlos = !Carlos;
            }
            
        }

        if (Carlos)
        {
            printf("Marcelo");
        }else{
            printf("Carlos");
        }
        printf("\n");
        
        scanf("%d", &nums);
        free(arr);
    }
    
    return 0;
}
