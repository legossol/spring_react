import React, { useState, useEffect,useCallback } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

const ItemRead = ({match}) => {
    console.log("ItemRead props:",JSON.stringify(match.params) )


    const [saleItem, setSaleItem] = useState({})
    const fetchRead = () =>{
        axios.get(`http://localhost:8080/saleItems/${localStorage.getItem('itemNo')}`)
        .then(res =>{
            console.log("자세한리스트를 가져옵니다",res);
            setSaleItem(res.data);

        })
        .catch(err => {
            console.log("에러러러러러ㅓ",err)
        })
    };
    useEffect(() => {
        fetchRead()
    }, []);
    const initialSaleItem = {itemNo: null,  title: '', hashTag: '', writer: '', itemPicture: '', content: '',price: '', soldOut: ''};
    // const [editing, setEditing] = useState(false);
    const [currentSaleItem, setCurrentSaleItem] = useState(initialSaleItem);
    
    const deleteItem = useCallback( () =>{
        axios.delete(`http://localhost:8080/saleItems/${localStorage.getItem('itemNo')}`)
        .then(res =>{
            alert ('상품이 삭제되었습니다.')
            window.location = '/ItemBoard'
        })
        .catch(err => {
            console.log(err)
        })
    }
    )

        return (<>
                <table>
                <thead>
                    <tr>
                        <th>No</th>
                        <th>제목</th>
                        <th>해쉬태그</th>
                        <th>작성자</th>
                        <th>사진</th>
                        <th>내용</th>
                        <th>가격</th>
                        <th>등록일자</th>
                        <th>판매상태</th>
                    </tr>
                </thead>
                <tbody>
                            <tr key={saleItem.itemNo}>
                                <td>{saleItem.itemNo}</td>
                                <td>{saleItem.title}</td>
                                <td>{saleItem.hashTag}</td>
                                <td>{saleItem.writer}</td>
                                <td>{saleItem.itemPicture}</td>
                                <td>{saleItem.content}</td>
                                <td>{saleItem.price}</td>
                                <td>{saleItem.regDate}</td>
                                <td>{saleItem.soldOut}</td>
                                <td>
                                <button onClick={() => deleteItem()}>Delete</button>
                                <Link to={`/ItemEdit/${saleItem.itemNo}`}> <button>Edit</button> </Link>
                               
                                </td>
                            </tr>
                </tbody>
            </table>
        </>);
};
export default ItemRead;