// import React, { PropTypes } from 'react';
// import { useSelector } from 'react-redux';
// import { Link, useParams } from 'react-router-dom';

// const ListFilterLink = ({ filter, children }) => {
    
//     const fundings = useSelector(state =>{
//         return state.fundings.pageResult.dtoList
//       })
//   return(
//   <Link
//     to={filter === '모두 보기' ? '' : filter}
//     activeStyle={{
//       textDecoration: 'none',
//       color: 'black',
//     }}
//   >
//     {children}
//   </Link>
// );
// }
// const currentFunding = useParams();
// currentFunding.hashtag = {
//   filter: currentFunding.hashtag.oneOf(['all', '교육', '가방']).isRequired,
//   children: currentFunding.hashtag.node.isRequired,
// };

// export default ListFilterLink;