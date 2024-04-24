; x64 Bootloader.
[org 0x7c00]

mov si, my_s
call print_s

; print_s(String message)
print_s:
    mov ah, 0x0E
    mov al, [si]
    loop:
        int 0x10
        inc si
        mov al, [si]
        cmp al, 0
        jne loop
    ret
ret

my_s db "Hello, World", 13, 10, 0

the_secret:
    db "X"

mov ah, 0x0e    ; int 10/ah -> Scrolling teletype BIOS routine.

; Set the stack pointers.
mov bp, 0x8000  ; Set the base of the stack above the bootsector.
mov sp, bp

; Demonstrate stack
push 'A'
push 'B'
push 'C'

pop bx          ; Pop to bx.
mov al, bl      ; Copy 8 bit char to al.
int 0x10        ; Print al.

pop bx          ; Pop next value to bx again.
mov al, bl
int 0x10

mov al, [0x7ffe]    ; 0x8000 - 0x2 (16 bits)
int 0x10

; Printing things...
mov al, the_secret
int 0x10

mov al, [the_secret]
int 0x10

mov bx, the_secret
add bx, 0x7c00
mov al, [bx]
int 0x10

mov al, [0x7c1e]
int 0x10

mov al, 'H'
int 0x10

; Conditionals
mov bx, 30
cmp bx, 4
jle block1
cmp bx, 40
jl block2
jmp block3

block1:
    mov al, 'X'
    jmp end

block2:
    mov al, 'Y'
    jmp end

block3:
    mov al, 'Z'
    jmp end

end:
    int 0x10

; Functions should push any registers it plans to alter onto the stack
; and then pop them off again. Restores to values. pusha and popa
; push and pop all registers to and from the stack.
som_function:
    pusha
    mov bx, 10
    add bx, 20
    mov ah, 0x0e
    int 0x10
    popa
    ret

; Printing hex numbers to screen.
mov dx, 0x1fb6
call print_hex

print_hex:
    mov bx, HEX_OUT
    call print_s
    ret

HEX_OUT: db '0x0000', 0

; Disk Read Routine.
disk_load:
    mov ah, 0x02    ; BIOS read sector function.
    mov dl, 0       ; Read drive 0 (first disk)
    mov ch, 3       ; Select cyinder 3.
    mov dh, 1       ; 2nd side of disk
    mov cl, 4       ; 4th sector on track
    mov al, 5       ; Read 5 sectors.
    mov bx, 0xa000  ; Address to read TO. ES:BX
    mov es, bx
    mov bx, 0x1234  ; Read into 0xa000:0x1234
    int 0x13        ; Read
    jc disk_error   ; Jump if carry flag was set in read error.
    cmp al, 5
    jne disk_error

disk_error:
    mov bx, disk_error_msg
    call print_s
    jmp $

disk_error_msg: db "Disk Read Error", 0

jmp $
times 510 - ($-$$) db 0
dw 0xaa55