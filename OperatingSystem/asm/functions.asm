;; int slen (String message)
slen:
    push ebx
    mov ebx, eax    ; eax contains address to string.

nextchar:
    cmp byte [eax], 0
    jz finished
    inc eax
    jmp nextchar

finished:
    sub eax, ebx
    pop ebx
    ret


;; void sprint(String message)
sprint:
    push edx
    push ecx
    push ebx
    push eax
    call slen

    mov edx, eax
    pop eax

    mov ecx, eax
    mov ebx, 1
    mov eax, 4
    int 80h

    pop ebx
    pop ecx
    pop edx
    ret


;; void exit()
quit:
    mov ebx, 0
    mov eax, 1
    int 80h
    ret