; Subroutines are declared using labels.
; We use CALL to get to them. We use RET to return from a subroutine.
; CALL and RET 

SECTION .data
msg db 'Hello, brave new world!', 0Ah

SECTION text
global _start

_start:
    mov eax, msg
    call strlen

    mov edx, eax
    mov ecx, msg
    mov ebx, 1
    mov eax, 4
    int 80h

    mov ebx, 0
    mov eax, 1
    int 80h

strlen:
    push ebx        ; Push to stack to preserve it while we use EBX.
    mov ebx, eax    ; Both point to same address.

nextchar:
    cmp byte [eax], 0
    jz finished
    inc eax
    jmp nextchar

finished:
    sub eax, ebx
    pop ebx
    ret