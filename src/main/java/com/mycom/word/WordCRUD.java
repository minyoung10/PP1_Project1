package com.mycom.word;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD {
    ArrayList<Word> list;
    Scanner s;
    WordCRUD(Scanner s){
        list = new ArrayList<>();
        this.s = s;
    }

    @Override
    public Object add() {
        System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
        int level =s.nextInt();
        String word =s.next();
        s.nextLine(); // 엔터 키를 소비하기 위해 빈 라인 읽기
        System.out.print("뜻 입력 : ");
        String meaning = s.nextLine();
        return new Word(0,level,word,meaning);
    }
    public void addWord(){
        Word one = (Word)add();
        list.add(one);
        System.out.println("새 단어가 단어장에 추가되었습니다. ");
    }
    @Override
    public int update(Object obj) {return 0;}


    @Override
    public int delete(Object obj) {
        return 0;
    }

    @Override
    public void selectOne(int id) {}

    public void listAll(){
        System.out.println("-------------------------------");
        for (int i=0; i< list.size(); i++){
            System.out.print((i+1)+" ");
            System.out.println(list.get(i).toString());
        }
        System.out.println("-------------------------------");
    }

    public ArrayList<Integer> listAll(String keyword){
        int j=0;
        ArrayList<Integer> idlist = new ArrayList<>();
        System.out.println("-------------------------------");
        for (int i=0; i< list.size(); i++){
            String word = list.get(i).getWord();
            if (word.contains(keyword)) {
                System.out.print((j+1)+" ");
                System.out.println(list.get(i).toString());
                idlist.add(i);
                j++;
                continue;
            }
        }
        System.out.println("-------------------------------");
        return idlist;
    }
    public void updateItem() {
    System.out.print("=> 수정할 단어 검색 : ");
    String keyword =s.next();
    ArrayList<Integer> idlist = this.listAll(keyword);
    System.out.print("=> 수정할 번호 선택 : ");
    int id =s.nextInt();
    s.nextLine();
    System.out.print("뜻 입력 : ");
    String meaning = s.nextLine();
    Word word = list.get(idlist.get(id-1));
    word.setMeaning(meaning);
    System.out.println("단어 수정이 성공적으로 되었습니다!!");
    }

    public void deleteItem() {
        System.out.print("=> 삭제할 단어 검색 : ");
        String keyword =s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
        System.out.print("=> 삭제할 번호 선택 : ");
        int id =s.nextInt();
        s.nextLine();
        System.out.print("정말로 삭제하실래요?(Y/n) : ");
        String ans = s.nextLine();
        if(ans.equalsIgnoreCase("y")){
            list.remove((int)idlist.get(id-1));
            System.out.println("단어가 삭제되었습니다.");
        }
        else
            System.out.println("취소 되었습니다.");

    }

    public void searchWord() {
        System.out.print("=> 검색할 단어 검색 : ");
        String keyword =s.next();
        ArrayList<Integer> idlist = this.listAll(keyword);
    }
}
